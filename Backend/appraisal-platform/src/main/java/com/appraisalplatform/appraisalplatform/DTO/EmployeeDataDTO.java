package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDataDTO {

    private Employee employee;

    private RatingDTO rating;
}
