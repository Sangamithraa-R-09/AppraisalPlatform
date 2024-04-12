package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.ManagerForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerFormRepo extends JpaRepository<ManagerForm,Long> {
    List<ManagerForm> getByEmpId(Long empId);

    List<ManagerForm> findByEmpId(Long empId);

    List<ManagerForm> findByManagerIdAndFormYear(Long empId,Integer year);
}
