package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.Goals;
import com.appraisalplatform.appraisalplatform.Model.ManagerGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerGoalsRepo extends JpaRepository<ManagerGoals,Long> {

    List<ManagerGoals> findByEmpId(Long empId);

//    List<ManagerGoals> findByEmpId(Long empId);


//    void deleteByGoals_goalId(Long goalsId);
}
