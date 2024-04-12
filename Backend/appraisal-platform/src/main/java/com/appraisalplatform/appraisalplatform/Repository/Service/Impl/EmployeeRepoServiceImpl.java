package com.appraisalplatform.appraisalplatform.Repository.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeDTO;
import com.appraisalplatform.appraisalplatform.DTO.EmployeeDataDTO;
import com.appraisalplatform.appraisalplatform.DTO.RatingDTO;
import com.appraisalplatform.appraisalplatform.DTO.TotalAppraisalStatusDTO;
import com.appraisalplatform.appraisalplatform.Model.*;
import com.appraisalplatform.appraisalplatform.Repository.*;
import com.appraisalplatform.appraisalplatform.Repository.Service.EmployeeRepoService;
import com.appraisalplatform.appraisalplatform.Service.Impl.JwtService;
import com.appraisalplatform.appraisalplatform.Service.Impl.UserDetailsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepoServiceImpl implements EmployeeRepoService, UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmployeeFormRepo employeeFormRepo;

    @Autowired
    private ManagerFormRepo managerFormRepo;

    @Override
    public ResponseEntity<?> addEmployee(EmployeeDTO employeeDTO) {
        try {
            Employee employeeDetails = Employee.builder()
                            .empId(employeeDTO.getEmpId())
                            .Designation(employeeDTO.getDesignation())
                            .firstName(employeeDTO.getFirstName())
                            .lastName(employeeDTO.getLastName())
                            .dob(employeeDTO.getDob())
                            .mobile(employeeDTO.getMobile())
                            .email(employeeDTO.getEmail())
                            .profilePath(employeeDTO.getProfilePath())
                            .joiningDate(employeeDTO.getJoiningDate())
                            .role(employeeDTO.getRole())
                            .projects(employeeDTO.getProjects())
                            .build();

            employeeRepo.save(employeeDetails);
            return new ResponseEntity("Data added Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error occured", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getEmployeeDetails(String email) {
        try {

            Employee employee = employeeRepo.findByEmail(email);
            if(employee.getDesignation().equals("manager")){
                EmployeeDataDTO employeeDataDetails = EmployeeDataDTO.builder()
                        .employee(employee)
                        .rating(null)
                        .build();
                return new ResponseEntity<>(employeeDataDetails,HttpStatus.OK);
            }
            List<ManagerForm> managerFormList = managerFormRepo.findByEmpId(employee.getEmpId());
            ManagerForm managerForm = managerFormList.get(0);

            RatingDTO rating = RatingDTO.builder()
                    .QualityOfWorkRating(managerForm.getQualityOfWorkRating())
                    .CommunicationRating(managerForm.getCommunicationRating())
                    .AdaptabilityRating(managerForm.getPotentialRating())
                    .InitiativesRating(managerForm.getInitiativesRating())
                    .ReusableLibraryRating(managerForm.getReusableLibrariesRating())
                    .TeamWorkRating(managerForm.getTeamWorkRating())
                    .TechTalkRating(managerForm.getTechTalksRating())
                    .build();

            EmployeeDataDTO employeeDataDetails = EmployeeDataDTO.builder()
                    .employee(employee)
                    .rating(rating)
                    .build();
            return new ResponseEntity<>(employeeDataDetails,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error" + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> checkEmail(String email) {
        try{
            Optional<Employee> employee = employeeRepo.getByEmail(email);
            if(employee.isPresent()){
                return new ResponseEntity<>(jwtService.generateToken(email),HttpStatus.OK);
            }
            return new ResponseEntity<>("Email not found",HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<>("error" + e,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<?> getAllAppraisalStatus(Integer year) {
        try{
            List<Employee> employeeList = employeeRepo.findAll();
            List<EmployeeForm> employeeForm = employeeFormRepo.findByFormYear(year);
            int totalEmployee = employeeList.size();
            int submittedEmployees = employeeForm.size();
            TotalAppraisalStatusDTO totalAppraisalStatusDTO = TotalAppraisalStatusDTO.builder()
                    .totalEmployees(totalEmployee)
                    .submittedCount(submittedEmployees)
                    .pendingCount(totalEmployee-submittedEmployees)
                    .build();

            return new ResponseEntity<>(totalAppraisalStatusDTO,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("error" + e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> userDetails = employeeRepo.getByEmail(email);

        return userDetails.map(UserDetailsInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + email));
    }
}
