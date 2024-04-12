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
public class EmployeeRatingYearWiseDTO {

    private Integer year;

    private Double rating;
}
