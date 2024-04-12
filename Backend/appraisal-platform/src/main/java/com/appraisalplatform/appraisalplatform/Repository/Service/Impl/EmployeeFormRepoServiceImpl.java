package com.appraisalplatform.appraisalplatform.Repository.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.*;
import com.appraisalplatform.appraisalplatform.Model.*;
import com.appraisalplatform.appraisalplatform.Repository.*;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeFormRepoService;
import com.appraisalplatform.appraisalplatform.Service.Impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.*;

@Service
public class EmployeeFormRepoServiceImpl implements EmployeeFormRepoService {

    @Autowired
    private EmployeeWorksRepo employeeWorksRepo;

    @Autowired
    private EmployeeFormRepo employeeFormRepo;

    @Autowired
    private EmployeeCertificatesRepo employeeCertificatesRepo;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public ResponseEntity<?> addEmployeeForm(EmployeeFormDTO employeeFormData) {
        try{

            List<EmployeeWorks> employeeWorksList =  employeeFormData.getEmployeeWorks();
            for(EmployeeWorks employeeWorks : employeeWorksList){
                employeeWorks.setEmpId(employeeFormData.getEmpId());
                employeeWorksRepo.save(employeeWorks);
            }

            List<EmployeeCertificates> employeeCertificates =  employeeFormData.getEmployeeCertificates();
            for(EmployeeCertificates certificates : employeeCertificates){
                certificates.setEmpId(employeeFormData.getEmpId());
                employeeCertificatesRepo.save(certificates);
            }

            List<EmployeeForm> employeeFormList = employeeFormRepo.findByEmpId(employeeFormData.getEmpId());
            if(!employeeFormList.isEmpty() && employeeFormList.get(0).getFormYear() == Integer.parseInt(String.valueOf(Year.now().getValue()))){
                return new ResponseEntity<>("Data already present in EmployeeForm", HttpStatus.OK);
            }

            EmployeeForm employeeFormClass = EmployeeForm.builder()
                            .empId(employeeFormData.getEmpId())
                            .managerId(employeeFormData.getManagerId())
                            .achievement(employeeFormData.getAchievement())
                            .role(employeeFormData.getRole())
                            .communication(employeeFormData.getCommunication())
                            .teamWork(employeeFormData.getTeamWork())
                            .technicalExpertise(employeeFormData.getTechnicalExpertise())
                            .initiatives(employeeFormData.getInitiatives())
                            .potential(employeeFormData.getPotential())
                            .reusableLibraries(employeeFormData.getReusableLibraries())
                            .techTalks(employeeFormData.getTechTalks())
                            .anythingElse(employeeFormData.getAnythingElse())
                            .formYear(Integer.parseInt(String.valueOf(Year.now())))
                            .employeeWorks(employeeFormData.getEmployeeWorks())
                            .employeeCertificates(employeeFormData.getEmployeeCertificates())
                            .build();

            emailSenderService.sendEmailEmployeeForm(employeeFormData);
            employeeFormRepo.save(employeeFormClass);
            return new ResponseEntity<>("Data added to Employee Form", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getFormData(Long empId) {
        try {
            List<EmployeeForm> employeeFormList = employeeFormRepo.findByEmpId(empId);
            if(employeeFormList.isEmpty()){
                return new ResponseEntity<>("No works found",HttpStatus.BAD_REQUEST);
            }
            EmployeeWorksDTO employeeWorksDTO = EmployeeWorksDTO.builder()
                    .employeeWorks(employeeFormList.get(0).getEmployeeWorks())
                    .build();
            return new ResponseEntity<>(employeeWorksDTO,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("done" + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<EmployeeForm>> getAllData() {
        try {
            return new ResponseEntity<>(employeeFormRepo.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeHistory(Long empId) {
        try {

            List<EmployeeForm> employeeFromList = employeeFormRepo.findByEmpId(empId);

            if(employeeFromList.isEmpty())
                return new ResponseEntity<>("Employee History Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
            Optional<Manager> managerList = managerRepo.findById(employeeFromList.get(0).getManagerId());

            EmployeeAppraisalHistoryDTO employeeAppraisalHistoryDetails = EmployeeAppraisalHistoryDTO.builder()
                    .employeeForm(employeeFromList)
                    .managerName(managerList.get().getManagerName())
                    .build();

            return new ResponseEntity<>(employeeAppraisalHistoryDetails,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error " + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeAppraisalYear(Long empId) {
        try {
            List<EmployeeForm> employeeFromList = employeeFormRepo.findByEmpId(empId);
            if(employeeFromList.isEmpty())
                return new ResponseEntity<>("Employee History Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
            Optional<Manager> manager = managerRepo.findById(employeeFromList.get(0).getManagerId());
            List<EmployeeAppraisalHistoryYearDTO> employeeAppraisalHistoryYearList = new ArrayList<>();

            for (EmployeeForm employeeForm : employeeFromList) {
                EmployeeAppraisalHistoryYearDTO employeeAppraisalHistoryYear = EmployeeAppraisalHistoryYearDTO.builder()
                        .year(employeeForm.getFormYear())
                        .managerName(manager.isPresent() ? manager.get().getManagerName() : null)
                        .build();
                employeeAppraisalHistoryYearList.add(employeeAppraisalHistoryYear);
            }

            return new ResponseEntity<>(employeeAppraisalHistoryYearList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeFormData(Long empId) {
        try {
            List<EmployeeForm> employeeFormList = employeeFormRepo.findByEmpId(empId);
            if(employeeFormList.isEmpty()){
                return new ResponseEntity<>("Employee not submitted",HttpStatus.INTERNAL_SERVER_ERROR);

            }
            int yearIndex = 0,index=0;

            for(EmployeeForm employeeForm : employeeFormList){
                if(employeeForm.getFormYear() == Integer.parseInt(String.valueOf(Year.now()))){
                    yearIndex = index;
                    break;
                }
                index++;
            }

            EmployeeForm employeeFormCurrentYearData = employeeFormList.get(yearIndex);
            EmployeeFormSubmissionDetailsDTO employeeFormSubmissionDetails = EmployeeFormSubmissionDetailsDTO.builder()
                    .achievement(employeeFormCurrentYearData.getAchievement())
                    .role(employeeFormCurrentYearData.getRole())
                    .communication(employeeFormCurrentYearData.getCommunication())
                    .teamWork(employeeFormCurrentYearData.getTeamWork())
                    .technicalExpertise(employeeFormCurrentYearData.getTechnicalExpertise())
                    .initiatives(employeeFormCurrentYearData.getInitiatives())
                    .potential(employeeFormCurrentYearData.getPotential())
                    .reusableLibraries(employeeFormCurrentYearData.getReusableLibraries())
                    .techTalks(employeeFormCurrentYearData.getTechTalks())
                    .anythingElse(employeeFormCurrentYearData.getAnythingElse())
                    .formYear(employeeFormCurrentYearData.getFormYear())
                    .employeeWorks(employeeFormCurrentYearData.getEmployeeWorks())
                    .employeeCertificates(employeeFormCurrentYearData.getEmployeeCertificates())
                    .build();

            return new ResponseEntity<>(employeeFormSubmissionDetails,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getSpecificYearData(Long empId, Integer year) {
        try{
            return new ResponseEntity<>(employeeFormRepo.findByEmpIdAndFormYear(empId,year),HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Data not found",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeParticularYear(Long managerId, Integer year) {
        try{
            List<EmployeeForm> employeeFormList = employeeFormRepo.findByManagerIdAndFormYear(managerId, year);
            List<EmployeeHistoryDTO> employeeHistoryDTOList = new ArrayList<>();

            for(EmployeeForm employeeForm : employeeFormList){
                List<Employee> employeeList = employeeRepo.findByEmpId(employeeForm.getEmpId());

                EmployeeHistoryDTO employeeHistoryDTO = EmployeeHistoryDTO.builder()
                        .EmpID(employeeList.get(0).getEmpId())
                        .EmployeeName(employeeList.get(0).getFirstName())
                        .build();
                employeeHistoryDTOList.add(employeeHistoryDTO);
            }

            return new ResponseEntity<>(employeeHistoryDTOList,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Data not found" + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> checkFormExists(Long empId) {
        try{
            List<EmployeeForm> employeeForm = employeeFormRepo.findByEmpIdAndFormYear(empId,Integer.parseInt(String.valueOf(Year.now())));
            if(employeeForm.isEmpty()){
                return new ResponseEntity<>(false,HttpStatus.OK);
            }
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Data not found" + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
