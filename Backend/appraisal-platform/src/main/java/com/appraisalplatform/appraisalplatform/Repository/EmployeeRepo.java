package com.appraisalplatform.appraisalplatform.Repository;

import com.appraisalplatform.appraisalplatform.Model.Employee;
import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);

    List<Employee> findByEmpId(Long empId);

    Employee getByEmpId(Long empId);

    Optional<Employee> getByEmail(String email);

//    List<Employee> findByYear(Year year);
}
