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
public class ManagerFormDTO {

    private Long managerId;

    private Long empId;

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

    private Year formYear;
}
