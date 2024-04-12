package com.appraisalplatform.appraisalplatform.Controller;

import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeFormRepoService;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeRepoService;
import com.appraisalplatform.appraisalplatform.Repository.Service.ManagerGoalsRepoService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeFormService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeService;
import com.appraisalplatform.appraisalplatform.Service.ManagerGoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class CommonController {

    @Autowired
    private EmployeeRepoService employeeRepoService;

    @Autowired
    private EmployeeFormService employeeFormService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ManagerGoalsService managerGoalsService;
    @GetMapping("getData/{email}")
    public ResponseEntity<?> getDetails(@PathVariable String email){
        return employeeService.getEmployeeDetails(email);
    }

    @GetMapping("getFormFilledEmployeeData")
    public ResponseEntity<List<EmployeeForm>> getEmployeeData(){
        return employeeFormService.getAllData();
    }

    @GetMapping("checkEmailExists/{email}")
    public ResponseEntity<?> checkEmail(@PathVariable String email){
        return employeeRepoService.checkEmail(email);
    }

    @GetMapping("getGoals/{empId}")
    public ResponseEntity<?> getGoals(@PathVariable Long empId){
        return managerGoalsService.getGoals(empId);
    }



}
