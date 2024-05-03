package org.restaurant.controller;

import lombok.RequiredArgsConstructor;


import org.restaurant.mapstruct.dto.LocationDTO;
import org.restaurant.response.LocationResponse;
import org.restaurant.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getLocationsByUser(Authentication authentication){
        return locationService.getLocationsByUser(authentication);
    }
    @PutMapping("/{locationId}")
    public ResponseEntity<LocationDTO> updateLocationState(@PathVariable Long locationId, Authentication authentication) {
        return locationService.updateLocation(locationId, authentication);
    }


}
