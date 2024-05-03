package org.restaurant.mapstruct;

import java.util.Map;
import javax.annotation.processing.Generated;
import org.restaurant.model.MenuItemEntity;
import org.restaurant.model.enums.FoodAdditive;
import org.restaurant.model.enums.FoodCategory;
import org.restaurant.response.CustomMenuItemResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:58:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MenuItemMapperImpl implements MenuItemMapper {

    @Override
    public CustomMenuItemResponse menuItemEntityToMenuItemResponse(MenuItemEntity menuItemEntity) {
        if ( menuItemEntity == null ) {
            return null;
        }

        Long menuItemId = null;
        String name = null;
        String description = null;
        boolean available = false;
        FoodCategory category = null;
        Map<FoodAdditive, Double> foodAdditivePrices = null;
        Map<String, Double> sizesWithPrices = null;

        CustomMenuItemResponse customMenuItemResponse = new CustomMenuItemResponse( menuItemId, name, description, available, category, foodAdditivePrices, sizesWithPrices );

        return customMenuItemResponse;
    }
}
