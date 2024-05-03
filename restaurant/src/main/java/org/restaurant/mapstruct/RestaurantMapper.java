package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.restaurant.mapstruct.dto.RestaurantEntityDTO;
import org.restaurant.model.RestaurantEntity;
import org.restaurant.request.CreateRestaurantRequest;
import org.restaurant.response.RestaurantResponse;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(target = "name", ignore = false)
    RestaurantEntity restaurantRequestToRestaurantEntity(CreateRestaurantRequest request);
    @Mapping(target = "name", ignore = false)
    RestaurantResponse restaurantEntityToRestaurantResponse(RestaurantEntity restaurantEntity);

    @Mapping(target = "name", ignore = false)
    RestaurantEntityDTO restaurantEntityToRestaurantDTO(RestaurantEntity restaurantEntity);

}
