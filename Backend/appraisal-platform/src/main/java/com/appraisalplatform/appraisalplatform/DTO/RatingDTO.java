package com.appraisalplatform.appraisalplatform.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {

    private Double CommunicationRating;

    private Double InitiativesRating;

    private Double QualityOfWorkRating;

    private Double ReusableLibraryRating;

    private Double TeamWorkRating;

    private Double TechTalkRating;

    private Double AdaptabilityRating;

}
