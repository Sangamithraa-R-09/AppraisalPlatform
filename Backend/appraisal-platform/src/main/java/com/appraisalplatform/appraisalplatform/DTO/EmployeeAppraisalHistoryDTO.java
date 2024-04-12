package com.appraisalplatform.appraisalplatform.DTO;

import com.appraisalplatform.appraisalplatform.Model.EmployeeCertificates;
import com.appraisalplatform.appraisalplatform.Model.EmployeeForm;
import com.appraisalplatform.appraisalplatform.Model.EmployeeWorks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAppraisalHistoryDTO {

    private List<EmployeeForm> employeeForm;

    private String managerName;

}
