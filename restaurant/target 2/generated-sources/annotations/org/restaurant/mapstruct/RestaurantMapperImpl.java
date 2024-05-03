package org.restaurant.mapstruct;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.restaurant.mapstruct.dto.RestaurantEntityDTO;
import org.restaurant.model.RestaurantEntity;
import org.restaurant.request.CreateRestaurantRequest;
import org.restaurant.response.LocationResponse;
import org.restaurant.response.MenuItemResponse;
import org.restaurant.response.RestaurantResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:58:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public RestaurantEntity restaurantRequestToRestaurantEntity(CreateRestaurantRequest request) {
        if ( request == null ) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        return restaurantEntity;
    }

    @Override
    public RestaurantResponse restaurantEntityToRestaurantResponse(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        Long restaurantId = null;
        String name = null;
        String description = null;
        String phoneNumber = null;
        String openingHours = null;
        double rating = 0.0d;
        String foodType = null;
        String image = null;
        LocalDateTime createDate = null;
        List<LocationResponse> locations = null;
        List<MenuItemResponse> menuItems = null;
        long commentsCount = 0L;

        RestaurantResponse restaurantResponse = new RestaurantResponse( restaurantId, name, description, phoneNumber, openingHours, rating, foodType, image, createDate, locations, menuItems, commentsCount );

        return restaurantResponse;
    }

    @Override
    public RestaurantEntityDTO restaurantEntityToRestaurantDTO(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        RestaurantEntityDTO restaurantEntityDTO = new RestaurantEntityDTO();

        return restaurantEntityDTO;
    }
}
