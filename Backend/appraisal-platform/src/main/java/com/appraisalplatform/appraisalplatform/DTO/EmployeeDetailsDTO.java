package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import com.appraisalplatform.appraisalplatform.Model.Projects;
import com.appraisalplatform.appraisalplatform.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDTO {

    private Long empId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String mobile;
    private String email;
    private String profilePath;
    private Date joiningDate;

    private List<Role> role;
    private List<Projects> projects;
    private EmployeeForm employeeForm;
}
