package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeFormDTO;
import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import com.appraisalplatform.appraisalplatform.Repository.EmployeeFormRepo;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeFormRepoService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFormServiceImpl implements EmployeeFormService {

    @Autowired
    private EmployeeFormRepoService employeeFormRepoService;
    @Override
    public ResponseEntity<?> addEmployeeForm(EmployeeFormDTO employeeFormData) {
        return employeeFormRepoService.addEmployeeForm(employeeFormData);
    }

    @Override
    public ResponseEntity<?> getFormData(Long empId) {
        return employeeFormRepoService.getFormData(empId);
    }

    @Override
    public ResponseEntity<List<EmployeeForm>> getAllData() {
        return employeeFormRepoService.getAllData();
    }

    @Override
    public ResponseEntity<?> getEmployeeHistory(Long empId) {
        return employeeFormRepoService.getEmployeeHistory(empId);
    }

    @Override
    public ResponseEntity<?> getEmployeeAppraisalYear(Long empId) {
        return employeeFormRepoService.getEmployeeAppraisalYear(empId);
    }

    @Override
    public ResponseEntity<?> getEmployeeFormData(Long empId) {
        return employeeFormRepoService.getEmployeeFormData(empId);
    }

    @Override
    public ResponseEntity<?> getSpecificYearData(Long empId, Integer year) {
        return employeeFormRepoService.getSpecificYearData(empId,year);
    }

    @Override
    public ResponseEntity<?> getEmployeeParticularYear(Long empId, Integer year) {
        return employeeFormRepoService.getEmployeeParticularYear(empId,year);
    }

    @Override
    public ResponseEntity<?> checkFormExists(Long empId) {
        return employeeFormRepoService.checkFormExists(empId);
    }
}
