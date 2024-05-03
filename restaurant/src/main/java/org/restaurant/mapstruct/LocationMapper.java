package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurant.model.LocationEntity;
import org.restaurant.request.PostLocationRequest;
import org.restaurant.response.LocationResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationEntity locationRequestToLocationEntity(PostLocationRequest postLocationRequest);

    List<LocationResponse> locationEntityToLocationResponse(List<LocationEntity> locationEntity);

}
