package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HrDashboardDTO {

    private Long empId;

    private String name;

    private String profile;

    private String reviewedBy;

    private Boolean employeeStatus;

    private Boolean managerStatus;

}
