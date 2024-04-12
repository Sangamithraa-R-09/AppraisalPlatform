package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerGoalsDTO;
import com.appraisalplatform.appraisalplatform.Model.ManagerGoals;
import com.appraisalplatform.appraisalplatform.Repository.ManagerGoalsRepo;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerGoalsRepoService;
import com.appraisalplatform.appraisalplatform.Service.ManagerGoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerGoalsServiceImpl implements ManagerGoalsService {

    @Autowired
    private ManagerGoalsRepoService managerGoalsRepoService;

    @Override
    public ResponseEntity<?> addGoals(ManagerGoalsDTO managerGoals) {
        return managerGoalsRepoService.addGoals(managerGoals);
    }

    @Override
    public ResponseEntity<?> getGoals(Long empId) {
        return managerGoalsRepoService.getGoals(empId);
    }
    

}
