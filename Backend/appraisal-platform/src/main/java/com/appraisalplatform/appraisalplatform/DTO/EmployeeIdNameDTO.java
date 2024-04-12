package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdNameDTO {

    private Long EmpId;

    private String EmpName;
}
