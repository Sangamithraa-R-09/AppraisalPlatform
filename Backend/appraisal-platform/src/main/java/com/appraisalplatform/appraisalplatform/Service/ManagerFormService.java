package com.appraisalplatform.appraisalplatform.Service;

import com.appraisalplatform.appraisalplatform.DTO.ManagerFormDTO;
import com.appraisalplatform.appraisalplatform.Model.ManagerForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerFormService {
    ResponseEntity<?> addManagerForm(ManagerFormDTO employeeForm);

    ResponseEntity<List<ManagerForm>> getAllData();

    ResponseEntity<?> getOverAllRating(Long empId);
}
