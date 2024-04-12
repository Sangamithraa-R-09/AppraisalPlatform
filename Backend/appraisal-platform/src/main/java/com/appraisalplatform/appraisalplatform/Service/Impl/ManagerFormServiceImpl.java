package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.ManagerFormDTO;
import com.appraisalplatform.appraisalplatform.Model.ManagerForm;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerFormRepoService;
import com.appraisalplatform.appraisalplatform.Service.ManagerFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerFormServiceImpl implements ManagerFormService {

    @Autowired
    private ManagerFormRepoService managerFormRepoService;

    @Override
    public ResponseEntity<?> addManagerForm(ManagerFormDTO employeeForm) {
        return managerFormRepoService.addManagerForm(employeeForm);
    }

    @Override
    public ResponseEntity<List<ManagerForm>> getAllData() {
        return managerFormRepoService.getAllData();
    }

    @Override
    public ResponseEntity<?> getOverAllRating(Long empId) {
        return managerFormRepoService.getOverAllRating(empId);
    }
}
