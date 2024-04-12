package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.Employee;
import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.time.Year;
import java.util.List;


@Repository
public interface EmployeeFormRepo extends JpaRepository<EmployeeForm,Long> {
    List<EmployeeForm> findByEmpId(Long empId);

    List<EmployeeForm> findByEmpIdAndFormYear(Long empId, Integer year);

    List<EmployeeForm> findByManagerIdAndFormYear(Long managerId, Integer year);

    List<EmployeeForm> findByFormYear(Integer year);
}
