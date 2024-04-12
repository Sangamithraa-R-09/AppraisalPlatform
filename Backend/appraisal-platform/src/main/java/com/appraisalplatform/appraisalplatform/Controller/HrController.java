package com.appraisalplatform.appraisalplatform.Controller;

import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerRepoService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeService;
import com.appraisalplatform.appraisalplatform.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Hr")
public class HrController {


    @Autowired
    private ManagerService managerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("getAllFormData/{year}")
    public ResponseEntity<?> getFormData(@PathVariable Integer year){
        return managerService.getAllFormData(year);
    }

    @GetMapping("getAllAppraisalFormStatus/{year}")
    public  ResponseEntity<?> getAppraisalStatus(@PathVariable Integer year){
        return employeeService.getAllAppraisalStatus(year);
    }

}
