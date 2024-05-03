package org.restaurant.service;

import org.restaurant.mapstruct.dto.LocationDTO;
import org.restaurant.response.LocationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface LocationService {

    ResponseEntity<List<LocationResponse>> getLocationsByUser(Authentication authentication);

    ResponseEntity<LocationDTO> updateLocation(Long locationId, Authentication authentication);
}
