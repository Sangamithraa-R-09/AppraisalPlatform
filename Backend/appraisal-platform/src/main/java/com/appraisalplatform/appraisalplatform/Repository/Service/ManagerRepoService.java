package com.appraisalplatform.appraisalplatform.Repository.Service;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerDTO;
import com.appraisalplatform.appraisalplatform.Model.Employee;
import com.appraisalplatform.appraisalplatform.Model.Manager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerRepoService {
    ResponseEntity<Manager> addManager(ManagerDTO managerDetails);

    ResponseEntity<List<Employee>> getMangerEmployeeDetails(Long managerID);

    ResponseEntity<?> getEmployeeDataByManager(Long empId);

    ResponseEntity<?> getAllFormData(Integer year);

    ResponseEntity<?> getManagerProjects(Long managerId);

    ResponseEntity<?> getEmployees(Long managerID);

    ResponseEntity<?> getEmployeeStatus(Long managerID);
}
