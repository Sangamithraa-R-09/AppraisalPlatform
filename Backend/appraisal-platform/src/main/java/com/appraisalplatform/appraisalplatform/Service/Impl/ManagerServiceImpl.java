package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerDTO;
import com.appraisalplatform.appraisalplatform.Model.Employee;
import com.appraisalplatform.appraisalplatform.Model.Manager;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerRepoService;
import com.appraisalplatform.appraisalplatform.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{


    @Autowired
    private ManagerRepoService managerRepoService;

    @Override
    public ResponseEntity<Manager> addManager(ManagerDTO managerDetails) {
        return managerRepoService.addManager(managerDetails);
    }

    @Override
    public ResponseEntity<List<Employee>> getMangerEmployeeDetails(Long managerID) {
        return managerRepoService.getMangerEmployeeDetails(managerID);
    }

    @Override
    public ResponseEntity<?> getEmployeeDataByManager(Long empId) {
        return managerRepoService.getEmployeeDataByManager(empId);
    }

    @Override
    public ResponseEntity<?> getAllFormData(Integer year) {
        return managerRepoService.getAllFormData(year);
    }

    @Override
    public ResponseEntity<?> getManagerProjects(Long managerId) {
        return managerRepoService.getManagerProjects(managerId);
    }

    @Override
    public ResponseEntity<?> getEmployees(Long managerID) {
        return managerRepoService.getEmployees(managerID);
    }

    @Override
    public ResponseEntity<?> getEmployeesStatus(Long managerID) {
        return managerRepoService.getEmployeeStatus(managerID);
    }

}
