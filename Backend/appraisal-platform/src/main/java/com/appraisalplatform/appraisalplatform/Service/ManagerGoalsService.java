package com.appraisalplatform.appraisalplatform.Service;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerGoalsDTO;
import com.appraisalplatform.appraisalplatform.Model.ManagerGoals;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerGoalsService {

    ResponseEntity<?> addGoals(ManagerGoalsDTO managerGoals);

    ResponseEntity<?> getGoals(Long empId);



}
