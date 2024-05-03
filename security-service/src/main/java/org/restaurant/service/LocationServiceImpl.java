package org.restaurant.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.restaurant.mapstruct.LocationMapper;
import org.restaurant.mapstruct.dto.LocationDTO;
import org.restaurant.model.LocationEntity;
import org.restaurant.model.UserCredentialEntity;
import org.restaurant.repository.LocationRepository;
import org.restaurant.repository.UserCredentialRepository;
import org.restaurant.response.LocationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final UserCredentialRepository userCredentialRepository;


    @Override
    public ResponseEntity<List<LocationResponse>> getLocationsByUser(Authentication authentication) {

        UserCredentialEntity principal = (UserCredentialEntity) authentication.getPrincipal();

        UserCredentialEntity userEntity = userCredentialRepository.findById(principal.getId())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        List<LocationResponse> locationResponses = locationRepository
                .findAllByUserCredential(userEntity)
                .stream()
                .map(LocationMapper.INSTANCE::locationEntityToLocationResponse)
                .toList();

        return ResponseEntity.ok(locationResponses);
    }

    @Override
    @Transactional
    public ResponseEntity<LocationDTO> updateLocation(Long locationId, Authentication authentication) {

        UserCredentialEntity principal = (UserCredentialEntity) authentication.getPrincipal();

        UserCredentialEntity userEntity = userCredentialRepository.findById(principal.getId())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        LocationEntity location = locationRepository
                .findById(locationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));

        if (!location.getUserCredential().getUsername().equals(authentication.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not authorized to update this location");
        }
        List<LocationEntity> allUserLocations = locationRepository.findAllByUserCredential(userEntity);
        allUserLocations.forEach(loc -> {
            loc.setCurrent(false);
            locationRepository.save(loc);
        });

        location.setCurrent(true);
        LocationEntity updatedLocation = locationRepository.save(location);



        return ResponseEntity.ok(LocationMapper.INSTANCE
                .locationEntityToLocationDTO(updatedLocation));
    }
}
