package org.restaurant.mapstruct;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.restaurant.model.RatingEntity;
import org.restaurant.request.PostRatingRequest;
import org.restaurant.response.RatingResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:58:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingEntity ratingRequestToRatingEntity(PostRatingRequest postRatingRequest) {
        if ( postRatingRequest == null ) {
            return null;
        }

        RatingEntity ratingEntity = new RatingEntity();

        return ratingEntity;
    }

    @Override
    public RatingResponse ratingEntityToRatingResponse(RatingEntity ratingEntity) {
        if ( ratingEntity == null ) {
            return null;
        }

        double rating = 0.0d;
        String review = null;
        LocalDateTime createDate = null;

        RatingResponse ratingResponse = new RatingResponse( rating, review, createDate );

        return ratingResponse;
    }
}
