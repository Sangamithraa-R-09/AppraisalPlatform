package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_works")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long empProjectId;

    private Long empId;

    private Long projId;

    private String projectName;

    private String Description;

    private String roleInProject;

    private String duration;

}
