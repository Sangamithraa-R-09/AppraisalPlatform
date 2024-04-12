package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.Model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoalsRepo extends JpaRepository<Goals,Long> {
    @Query("SELECT g.goalName, g.progress, g.lastUpdatedDate FROM ManagerGoals mg JOIN mg.goals g WHERE mg.empId = :empId")
    ResponseEntity<List<GoalsDTO>> getGoals(Long empId);

    @Query("SELECT g FROM ManagerGoals mg JOIN mg.goals g WHERE mg.empId = :empId")
    List<Goals> findGoalsByEmpId(@Param("empId") Long empId);


    ResponseEntity<?> deleteBygoalName(String name);
}
