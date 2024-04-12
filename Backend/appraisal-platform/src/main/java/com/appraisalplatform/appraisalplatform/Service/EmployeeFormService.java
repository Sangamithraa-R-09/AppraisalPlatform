package com.appraisalplatform.appraisalplatform.Service;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeFormDTO;
import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeFormService {

    ResponseEntity<?> addEmployeeForm(EmployeeFormDTO employeeFormData);

    ResponseEntity<?> getFormData(Long empId);

    ResponseEntity<List<EmployeeForm>> getAllData();

    ResponseEntity<?> getEmployeeHistory(Long empId);

    ResponseEntity<?> getEmployeeAppraisalYear(Long empId);

    ResponseEntity<?> getEmployeeFormData(Long empId);

    ResponseEntity<?> getSpecificYearData(Long empId, Integer year);

    ResponseEntity<?> getEmployeeParticularYear(Long empId, Integer year);

    ResponseEntity<?> checkFormExists(Long empId);
}
