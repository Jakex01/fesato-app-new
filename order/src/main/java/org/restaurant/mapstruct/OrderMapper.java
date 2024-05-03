package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.restaurant.model.OrderEntity;
import org.restaurant.request.OrderRequest;
import org.restaurant.response.OrderResponse;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderEntity requestToEntity(OrderRequest orderRequest);

    OrderResponse orderEntityToOrderResponse(OrderEntity orderEntity);
}
