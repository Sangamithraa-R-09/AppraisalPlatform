package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_Certifiates")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCertificates {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long certificateId;

    private Long empId;

    private String certificateUrl;

    private String certificateDesc;
}
