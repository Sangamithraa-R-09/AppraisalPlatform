package com.appraisalplatform.appraisalplatform.Repository.Service;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerGoalsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ManagerGoalsRepoService {

    ResponseEntity<?> addGoals(ManagerGoalsDTO managerGoals);

    ResponseEntity<?> getGoals(Long empId);


}
