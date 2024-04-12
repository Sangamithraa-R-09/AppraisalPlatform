package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.Manager;
import com.appraisalplatform.appraisalplatform.Model.ManagerForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
    List<Manager> findByEmployee_EmpId(Long empId);

    Manager getByManagerId(Long managerId);
}
