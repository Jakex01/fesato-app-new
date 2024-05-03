package org.restaurant.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.restaurant.model.MenuItemEntity;
import org.restaurant.response.CustomMenuItemResponse;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    MenuItemMapper INSTANCE = Mappers.getMapper(MenuItemMapper.class);
    @Mapping(target = "name", ignore = false)
    CustomMenuItemResponse menuItemEntityToMenuItemResponse(MenuItemEntity menuItemEntity);

}
