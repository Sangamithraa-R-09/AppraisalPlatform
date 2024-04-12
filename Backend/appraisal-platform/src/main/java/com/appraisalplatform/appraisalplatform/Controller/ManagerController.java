package com.appraisalplatform.appraisalplatform.Controller;

import com.appraisalplatform.appraisalplatform.DTO.GoalsDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerFormDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerGoalsDTO;
import com.appraisalplatform.appraisalplatform.Model.*;
import com.appraisalplatform.appraisalplatform.Repository.Service.*;
import com.appraisalplatform.appraisalplatform.Service.EmployeeFormService;
import com.appraisalplatform.appraisalplatform.Service.ManagerFormService;
import com.appraisalplatform.appraisalplatform.Service.ManagerGoalsService;
import com.appraisalplatform.appraisalplatform.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Manager")
public class ManagerController {

   @Autowired
   private ManagerGoalsService managerGoalsService;


    @Autowired
    private EmployeeFormService employeeFormService;

    @Autowired
    private ManagerService managerService;

    @Autowired()
    private ManagerFormService managerFormService;

    @PostMapping("addManagerForm")
    public ResponseEntity<?> addManagerForm(@RequestBody ManagerFormDTO managerForm){
        return managerFormService.addManagerForm(managerForm);
    }

    @PostMapping("addGoal")
    public ResponseEntity<?> addGoal(@RequestBody ManagerGoalsDTO managerGoals){

        return managerGoalsService.addGoals(managerGoals);
    }

    @PostMapping("addManager")
    public ResponseEntity<?> addManager(@RequestBody ManagerDTO managerDetails){
        return managerService.addManager(managerDetails);
    }

    @GetMapping("getEmployeeWorks/{empId}")
    public ResponseEntity<?> get(@PathVariable Long empId){
        return employeeFormService.getFormData(empId);
    }

    @GetMapping("getFormFilledManagerData")
    public ResponseEntity<List<ManagerForm>> getManagerFilledData(){
        return managerFormService.getAllData();
    }

    @GetMapping("getManagerAndEmployee/{managerID}")
    public ResponseEntity<List<Employee>> getManagerAndEmployee(@PathVariable Long managerID){
        return managerService.getMangerEmployeeDetails(managerID);
    }

    @GetMapping("getEmployeeNameForParticularYear/{empId}/{year}")
    public ResponseEntity<?> getEmployeeNameForParticularYear(@PathVariable Long empId, @PathVariable Integer year){
        return employeeFormService.getEmployeeParticularYear(empId,year);
    }

    @GetMapping("getManagerFilledEmployeeData/{empId}")
    public ResponseEntity<?> getEmployeeDataByManager(@PathVariable Long empId){
       return managerService.getEmployeeDataByManager(empId);
    }

    @GetMapping("getOverAllRatingYearWise/{empId}")
    public ResponseEntity<?> getOverAllRating(@PathVariable Long empId){
        return managerFormService.getOverAllRating(empId);
    }

    @GetMapping("getManagerProjects/{managerId}")
    public ResponseEntity<?> getManagerProjects(@PathVariable Long managerId){
        return managerService.getManagerProjects(managerId);
    }

    @GetMapping("getEmployees/{managerID}")
    public ResponseEntity<?> getEmployees(@PathVariable Long managerID){
        return managerService.getEmployees(managerID);
    }

    @GetMapping("getEmployeeStatus/{managerID}")
    public ResponseEntity<?> getEmployeesStatus(@PathVariable Long managerID){
        return managerService.getEmployeesStatus(managerID);
    }



}
