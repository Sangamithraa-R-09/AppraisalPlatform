package com.appraisalplatform.appraisalplatform.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.Year;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ManagerForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ManagerFormId;

    private Long managerId;

    private Long empId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp submittedTime;

    private Double QualityOfWorkRating;

    private String QualityOfWorkFeedback;

    private Double CommunicationRating;

    private String CommunicationFeedback;

    private Double TeamWorkRating;

    private String TeamWorkFeedback;

    private Double TechnicalExpertiseRating;

    private String TechnicalExpertiseFeedback;

    private Double InitiativesRating;

    private String InitiativesFeedback;

    private Double potentialRating;

    private String potentialFeedback;

    private Double ReusableLibrariesRating;

    private String ReusableLibrariesFeedback;

    private Double TechTalksRating;

    private String TechTalksFeedback;

    private Double ContributionRating;

    private String ContributionFeedback;

    private Double OverAllRating;

    private String Feedback;

    private Integer formYear;
}
