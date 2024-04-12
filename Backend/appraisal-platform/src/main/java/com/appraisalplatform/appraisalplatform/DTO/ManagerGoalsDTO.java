package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.Goals;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerGoalsDTO {

//    private Long managerId;

    private Long empId;

    private List<Goals> goals;
}
