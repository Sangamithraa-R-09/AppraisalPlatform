package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.EmployeeCertificates;
import com.appraisalplatform.appraisalplatform.Model.EmployeeWorks;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeFormSubmissionDetailsDTO {

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

    private List<EmployeeWorks> employeeWorks;

    private List<EmployeeCertificates> employeeCertificates;
}
