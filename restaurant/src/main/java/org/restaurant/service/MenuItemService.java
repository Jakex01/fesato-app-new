package org.restaurant.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.restaurant.mapstruct.MenuItemMapper;
import org.restaurant.repository.MenuItemRepository;
import org.restaurant.response.CustomMenuItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;


    public ResponseEntity<CustomMenuItemResponse> getMenuItemEntityById(Long menuItemId) {
        return menuItemRepository
                .findById(menuItemId)
                .map(MenuItemMapper.INSTANCE::menuItemEntityToMenuItemResponse)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new EntityNotFoundException("Menu item not found with id: " + menuItemId));
    }
}
