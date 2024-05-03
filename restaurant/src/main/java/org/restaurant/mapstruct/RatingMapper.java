package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurant.model.RatingEntity;
import org.restaurant.request.PostRatingRequest;
import org.restaurant.response.RatingResponse;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);


    RatingEntity ratingRequestToRatingEntity(PostRatingRequest postRatingRequest);

    RatingResponse ratingEntityToRatingResponse (RatingEntity ratingEntity);
}
