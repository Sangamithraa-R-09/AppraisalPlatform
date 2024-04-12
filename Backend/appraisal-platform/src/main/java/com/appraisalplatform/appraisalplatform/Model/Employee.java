package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Entity
@Table(name = "Employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long empId;
    private String Designation;
    private String firstName;
    private String lastName;
    private Date dob;
    private String mobile;
    private String email;
    private String profilePath;
    private Date joiningDate;

    @ManyToMany
    private List<Role> role;

    @ManyToMany
    private List<Projects> projects;
}
