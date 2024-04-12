package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeDTO;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeRepoService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepoService employeeRepoService;

    @Override
    public ResponseEntity<?> addEmployee(EmployeeDTO employeeDTO) {

        return employeeRepoService.addEmployee(employeeDTO);
    }

    @Override
    public ResponseEntity<?> getEmployeeDetails(String email) {
        return employeeRepoService.getEmployeeDetails(email);
    }

    @Override
    public ResponseEntity<?> checkEmail(String email) {
        return employeeRepoService.checkEmail(email);
    }

    @Override
    public ResponseEntity<?> getAllAppraisalStatus(Integer year) {
        return employeeRepoService.getAllAppraisalStatus(year);
    }
}
