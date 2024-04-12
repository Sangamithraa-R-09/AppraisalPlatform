package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TotalAppraisalStatusDTO {

    private Integer totalEmployees;

    private Integer pendingCount;

    private Integer submittedCount;
}
