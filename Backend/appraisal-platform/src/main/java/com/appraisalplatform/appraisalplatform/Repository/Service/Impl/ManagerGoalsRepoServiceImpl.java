package com.appraisalplatform.appraisalplatform.Repository.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerGoalsDTO;
import com.appraisalplatform.appraisalplatform.Model.Goals;
import com.appraisalplatform.appraisalplatform.Model.Manager;
import com.appraisalplatform.appraisalplatform.Model.ManagerGoals;
import com.appraisalplatform.appraisalplatform.Repository.GoalsRepo;
import com.appraisalplatform.appraisalplatform.Repository.ManagerGoalsRepo;
import com.appraisalplatform.appraisalplatform.Repository.ManagerRepo;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerGoalsRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerGoalsRepoServiceImpl implements ManagerGoalsRepoService {

    @Autowired
    private ManagerGoalsRepo managerGoalsRepo;

    @Autowired
    private GoalsRepo goalsRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public ResponseEntity<?> addGoals(ManagerGoalsDTO managerGoals) {
        try{
            List<Manager> managerList = managerRepo.findByEmployee_EmpId(managerGoals.getEmpId());
            System.out.println(managerList);
            List<Goals> goalsList = managerGoals.getGoals();
            for(Goals goals : goalsList){
                goals.setLastUpdatedDate(new Date());
                goalsRepo.save(goals);
            }

            ManagerGoals managerGoalsData = ManagerGoals.builder()
                            .managerId(managerList.get(0).getManagerId())
                            .empId(managerGoals.getEmpId())
                            .goals(managerGoals.getGoals())
                            .build();
            managerGoalsRepo.save(managerGoalsData);
            return new ResponseEntity<>("Goals added", HttpStatus.OK);
        }
         catch (Exception e){
            return new ResponseEntity("Error occured" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getGoals(Long empId) {
        try{
            List<Goals> goals = goalsRepo.findGoalsByEmpId(empId);

            return new ResponseEntity<>(goals.stream()
                    .map(goal -> new GoalsDTO(goal.getGoalName(), goal.getProgress(), goal.getLastUpdatedDate()))
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Error occured" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
