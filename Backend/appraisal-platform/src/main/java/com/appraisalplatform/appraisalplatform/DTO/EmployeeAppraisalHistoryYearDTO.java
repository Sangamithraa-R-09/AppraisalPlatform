package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAppraisalHistoryYearDTO {

    private Integer year;

    private String managerName;
}
