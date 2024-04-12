package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Projects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long projectId;

    private String projectName;

    private Date startDate;

    private Date endDate;

}
