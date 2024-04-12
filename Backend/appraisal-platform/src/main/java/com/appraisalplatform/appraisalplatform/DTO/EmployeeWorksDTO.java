package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.EmployeeWorks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWorksDTO {

    private List<EmployeeWorks> employeeWorks;
}
