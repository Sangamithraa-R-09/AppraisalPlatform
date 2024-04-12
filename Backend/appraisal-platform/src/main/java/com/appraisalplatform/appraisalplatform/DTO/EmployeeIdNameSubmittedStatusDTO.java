package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdNameSubmittedStatusDTO {

    private Long EmpId;

    private String EmpName;

    private Boolean submittedStatus;
}
