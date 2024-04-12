package com.appraisalplatform.appraisalplatform.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoalsDTO {


    private String goalName;

    private Integer progress;

    private Date lastUpdatedDate;
}
