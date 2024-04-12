package com.appraisalplatform.appraisalplatform.Repository.Service;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepoService {

    ResponseEntity<?> addEmployee(EmployeeDTO employeeDTO);

    ResponseEntity<?> getEmployeeDetails(String email);

    ResponseEntity<?> checkEmail(String email);

    ResponseEntity<?> getAllAppraisalStatus(Integer year);
}
