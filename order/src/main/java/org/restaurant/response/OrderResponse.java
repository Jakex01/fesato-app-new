package org.restaurant.response;

import org.restaurant.model.MenuItemOrder;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Double totalPrice,
        String restaurantId,
        String restaurantName,
        List<MenuItemOrder> items,
        Double tip,
        String orderNote,
        LocalDateTime createDate,
        LocalDateTime deliveryDate
) {
}
