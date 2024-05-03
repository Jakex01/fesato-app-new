package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurant.mapstruct.dto.LocationDTO;
import org.restaurant.model.LocationEntity;
import org.restaurant.response.LocationResponse;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationResponse locationEntityToLocationResponse(LocationEntity locationEntity);

    LocationDTO locationEntityToLocationDTO(LocationEntity locationEntity);
}
