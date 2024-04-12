package com.appraisalplatform.appraisalplatform.Controller;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeDTO;
import com.appraisalplatform.appraisalplatform.DTO.EmployeeFormDTO;
import com.appraisalplatform.appraisalplatform.Repository.EmployeeFormRepo;
import com.appraisalplatform.appraisalplatform.Repository.EmployeeWorksRepo;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeFormRepoService;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeRepoService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeFormService;
import com.appraisalplatform.appraisalplatform.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    EmployeeRepoService employeeRepoService;

    @Autowired
    EmployeeFormRepo employeeFormRepo;

    @Autowired
    EmployeeWorksRepo employeeWorksRepo;

    @Autowired
    private EmployeeFormService employeeFormService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employeeDetails) {
        return employeeService.addEmployee(employeeDetails);
    }

    @PostMapping("addForm")
    public ResponseEntity<?> addEmpForm(@RequestBody EmployeeFormDTO employeeForm){

         return employeeFormService.addEmployeeForm(employeeForm);
    }

    @GetMapping("getEmployeeAppraisalHistory/{empId}")
    public ResponseEntity<?> getEmployeeHistory(@PathVariable Long empId){
        return employeeFormService.getEmployeeHistory(empId);
    }

    @GetMapping("getEmployeeAppraisalYear/{empId}")
    public ResponseEntity<?> getEmployeeAppraisalYear(@PathVariable Long empId){
        return employeeFormService.getEmployeeAppraisalYear(empId);
    }

    @GetMapping("getFormData/{empId}")
    public ResponseEntity<?> getFromData(@PathVariable Long empId){
        return employeeFormService.getEmployeeFormData(empId);
    }

    @GetMapping("getSpecificYearDatas/{empId}/{year}")
    public ResponseEntity<?> getSpecificData(@PathVariable Long empId, @PathVariable Integer year){
        return employeeFormService.getSpecificYearData(empId,year);
    }

    @GetMapping("checkFormStatus/{empId}")
    public ResponseEntity<?> checkFormStatus(@PathVariable Long empId){
        return employeeFormService.checkFormExists(empId);
    }


}
