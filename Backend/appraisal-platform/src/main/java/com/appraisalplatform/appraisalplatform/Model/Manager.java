package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @Id
    private Long managerId;

    private String managerName;

    private String managerEmail;

    @ManyToMany
    private List<Employee> employee;
}
