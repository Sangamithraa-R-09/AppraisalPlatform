package com.appraisalplatform.appraisalplatform.Repository.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.*;
import com.appraisalplatform.appraisalplatform.Model.*;
import com.appraisalplatform.appraisalplatform.Repository.*;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManagerRepoServiceImpl implements ManagerRepoService {

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private ManagerFormRepo managerFormRepo;

    @Autowired
    private EmployeeFormRepo employeeFormRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public ResponseEntity<Manager> addManager(ManagerDTO managerDetails) {
        try{
            Manager manager = Manager.builder()
                            .managerId(managerDetails.getManagerId())
                            .managerName(managerDetails.getManagerName())
                            .managerEmail(managerDetails.getManagerEmail())
                            .employee(managerDetails.getEmployee())
                            .build();
            managerRepo.save(manager);

            return new ResponseEntity("Data added to manager Repo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Employee>> getMangerEmployeeDetails(Long managerID) {
        try {
            return new ResponseEntity(managerRepo.findById(managerID), HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeDataByManager(Long empId) {
        try {
            return new ResponseEntity(managerFormRepo.findByEmpId(empId), HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllFormData(Integer year) {
        try {
            List<EmployeeForm> employee = employeeFormRepo.findByFormYear(year);
            List<HrDashboardDTO> hrDashboardDTOList = new ArrayList<>();
            for(EmployeeForm employeeDetails : employee){
                Boolean employeeFormStatus = true,managerFormStatus = true;
                List<Manager> managerList = managerRepo.findByEmployee_EmpId(employeeDetails.getEmpId());
                Employee employeeData = employeeRepo.getByEmpId(employeeDetails.getEmpId());

                List<EmployeeForm> employeeForms = employeeFormRepo.findByEmpIdAndFormYear(employeeDetails.getEmpId(),year);


                if(employeeForms.isEmpty()){
                    employeeFormStatus = false;
                }
                List<ManagerForm> managerForms = managerFormRepo.findByManagerIdAndFormYear(employeeDetails.getEmpId(),year);

                if(managerForms.isEmpty()){
                    managerFormStatus = false;
                }

                HrDashboardDTO dashboardDTO = HrDashboardDTO.builder()
                        .empId(employeeDetails.getEmpId())
                        .profile(employeeData.getProfilePath())
                        .name(employeeData.getFirstName())
                        .reviewedBy(managerList.get(0).getManagerName())
                        .employeeStatus(employeeFormStatus)
                        .managerStatus(managerFormStatus)
                        .build();
                hrDashboardDTOList.add(dashboardDTO);

            }
            return new ResponseEntity(hrDashboardDTOList, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getManagerProjects(Long managerId) {
        try{
            Manager managerData = managerRepo.getByManagerId(managerId);
            List<ManagerProjectsDTO> managerProjectDTOS = new ArrayList<>();
            if(managerData == null){
                return new ResponseEntity("Manager not found" , HttpStatus.BAD_REQUEST);
            }
            List<Employee> employeeList = managerData.getEmployee();
            for(Employee employee : employeeList){
                List<Projects> projectsList = employee.getProjects();
                for(Projects projects : projectsList){
                    ManagerProjectsDTO managerProject = ManagerProjectsDTO.builder()
                                    .projectsName(projects.getProjectName())
                                            .build();
                    if(!managerProjectDTOS.contains(managerProject)){
                        managerProjectDTOS.add(managerProject);
                    }
                }
            }
            return new ResponseEntity<>(managerProjectDTOS,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getEmployees(Long managerID) {
        try{
            List<Employee> employeeList = managerRepo.getByManagerId(managerID).getEmployee();
            List<EmployeeIdNameDTO> employeeIdNameDTOList = new ArrayList<>();
            for(Employee employeeDetails : employeeList){
                EmployeeIdNameDTO employeeIdNameDTO = EmployeeIdNameDTO
                        .builder()
                        .EmpId(employeeDetails.getEmpId())
                        .EmpName(employeeDetails.getFirstName())
                        .build();
                employeeIdNameDTOList.add(employeeIdNameDTO);
            }
            return new ResponseEntity<>(employeeIdNameDTOList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeStatus(Long managerID) {
        try{
            List<Employee> employeeList = managerRepo.getByManagerId(managerID).getEmployee();
            List<EmployeeIdNameSubmittedStatusDTO> employeeIdNameDTOList = new ArrayList<>();
            for(Employee employeeDetails : employeeList){
                List<EmployeeForm> employeeForm = employeeFormRepo.findByEmpIdAndFormYear(employeeDetails.getEmpId(),Integer.parseInt(String.valueOf(Year.now())));
                EmployeeIdNameSubmittedStatusDTO employeeIdNameDTO = EmployeeIdNameSubmittedStatusDTO
                        .builder()
                        .EmpId(employeeDetails.getEmpId())
                        .EmpName(employeeDetails.getFirstName())
                        .submittedStatus(!employeeForm.isEmpty())
                        .build();
                employeeIdNameDTOList.add(employeeIdNameDTO);
            }

            return new ResponseEntity<>(employeeIdNameDTOList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }


}
