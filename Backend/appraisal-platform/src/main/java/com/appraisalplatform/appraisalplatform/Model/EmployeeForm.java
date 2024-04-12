package com.appraisalplatform.appraisalplatform.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "employee_form")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EmployeeForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeFormId;

    private Long empId;

    private Long managerId;

    private String achievement;

    private String role;

    private String communication;

    private String teamWork;

    private String technicalExpertise;

    private String initiatives;

    private String potential;

    private String reusableLibraries;

    private String techTalks;

    private String anythingElse;

    private Integer formYear;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp submittedTime;

    @ManyToMany
    private List<EmployeeWorks> employeeWorks;

    @OneToMany
    private List<EmployeeCertificates> employeeCertificates;

}
