package org.restaurant.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.restaurant.mapstruct.RatingMapper;
import org.restaurant.repository.RatingRepository;
import org.restaurant.request.PostRatingRequest;
import org.restaurant.response.RatingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    public ResponseEntity<?> postRating(PostRatingRequest postRatingRequest) {
        ratingRepository.save(RatingMapper.INSTANCE.ratingRequestToRatingEntity(postRatingRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public ResponseEntity<List<RatingResponse>> getRatingByRestaurantId(Long restaurantId) {
       List<RatingResponse> ratingEntityList =  ratingRepository
                .findAllByRestaurantRestaurantId(restaurantId)
               .stream()
               .map(RatingMapper.INSTANCE::ratingEntityToRatingResponse)
               .toList();

       return ResponseEntity.ok(ratingEntityList);
    }

    public ResponseEntity<RatingResponse> getAverageRatingByRestaurantId(Long restaurantId, Double averageRating) {
        RatingResponse ratingResponse = ratingRepository
                .findAllByRestaurantRestaurantId(restaurantId)
                .stream()
                .min(Comparator.comparingDouble(rating ->
                        Math.abs(rating.getRating() - averageRating)))
                .map(RatingMapper.INSTANCE::ratingEntityToRatingResponse)
                .orElse(null);

        return ResponseEntity.ok(ratingResponse);
    }
}
