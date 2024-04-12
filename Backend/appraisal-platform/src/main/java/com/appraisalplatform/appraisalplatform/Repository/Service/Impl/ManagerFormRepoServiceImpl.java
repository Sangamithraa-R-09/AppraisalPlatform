package com.appraisalplatform.appraisalplatform.Repository.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeRatingYearWiseDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerFormDTO;
import com.appraisalplatform.appraisalplatform.Model.Manager;
import com.appraisalplatform.appraisalplatform.Model.ManagerForm;
import com.appraisalplatform.appraisalplatform.Repository.ManagerFormRepo;
import com.appraisalplatform.appraisalplatform.Repository.ManagerRepo;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerFormRepoService;
import com.appraisalplatform.appraisalplatform.Service.Impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerFormRepoServiceImpl implements ManagerFormRepoService {

    @Autowired
    private ManagerFormRepo managerFormRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public ResponseEntity<?> addManagerForm(ManagerFormDTO mangerForm) {
        try{
            Optional<Manager> managers = managerRepo.findById(mangerForm.getManagerId());
            List<ManagerForm> managerFormList = managerFormRepo.getByEmpId(mangerForm.getEmpId());
            if(!managerFormList.isEmpty() && managerFormList.get(0).getFormYear() == Integer.parseInt(String.valueOf(Year.now()))){
                return new ResponseEntity<>("Data already present in EmployeeForm", HttpStatus.OK);
            }

            ManagerForm managerFormDetails = ManagerForm.builder()
                            .managerId(mangerForm.getManagerId())
                            .empId(mangerForm.getEmpId())
                            .managerId(managers.get().getManagerId())
                            .QualityOfWorkRating(mangerForm.getQualityOfWorkRating())
                            .QualityOfWorkFeedback(mangerForm.getQualityOfWorkFeedback())
                            .CommunicationRating(mangerForm.getCommunicationRating())
                            .CommunicationFeedback(mangerForm.getCommunicationFeedback())
                            .TeamWorkRating(mangerForm.getTeamWorkRating())
                            .TeamWorkFeedback(mangerForm.getTeamWorkFeedback())
                            .TechnicalExpertiseRating(mangerForm.getTechnicalExpertiseRating())
                            .TechnicalExpertiseFeedback(mangerForm.getTechnicalExpertiseFeedback())
                            .InitiativesRating(mangerForm.getInitiativesRating())
                            .InitiativesFeedback(mangerForm.getInitiativesFeedback())
                            .potentialRating(mangerForm.getPotentialRating())
                            .potentialFeedback(mangerForm.getPotentialFeedback())
                            .ReusableLibrariesRating(mangerForm.getReusableLibrariesRating())
                            .ReusableLibrariesFeedback(mangerForm.getReusableLibrariesFeedback())
                            .TechTalksRating(mangerForm.getTechTalksRating())
                            .TechTalksFeedback(mangerForm.getTechTalksFeedback())
                            .ContributionRating(mangerForm.getContributionRating())
                            .ContributionFeedback(mangerForm.getContributionFeedback())
                            .OverAllRating(mangerForm.getOverAllRating())
                            .Feedback(mangerForm.getFeedback())
                            .formYear(Integer.parseInt(String.valueOf(Year.now())))
                            .build();

            emailSenderService.sendEmailManagerForm(mangerForm);
            managerFormRepo.save(managerFormDetails);
            return new ResponseEntity("Data added Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error occured" + e, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<ManagerForm>> getAllData(){
        try{

            return new ResponseEntity(managerFormRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error occured", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getOverAllRating(Long empId) {
        try{
            List<ManagerForm> managerFormList = managerFormRepo.findByEmpId(empId);
            List<EmployeeRatingYearWiseDTO> employeeRatingYearWiseDTOS = new ArrayList<>();
            for(ManagerForm managerForm : managerFormList){
                EmployeeRatingYearWiseDTO ratingYearWise = EmployeeRatingYearWiseDTO.builder()
                        .year(managerForm.getFormYear())
                        .rating(managerForm.getOverAllRating())
                        .build();
                employeeRatingYearWiseDTOS.add(ratingYearWise);
            }

            return new ResponseEntity(employeeRatingYearWiseDTOS, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity("Error occured", HttpStatus.BAD_REQUEST);
        }
    }


}
