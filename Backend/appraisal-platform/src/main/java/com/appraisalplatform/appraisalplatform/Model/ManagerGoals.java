package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerGoals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ManagerGoalsId;

    private Long managerId;

    private Long empId;

    @ManyToMany
    private List<Goals> goals;

}
