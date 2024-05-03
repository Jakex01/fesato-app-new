package org.restaurant.mapstruct.dto;

public record LocationDTO(
         String city,
         String street,
         String streetNumber,
         String country,
         String postalCode,
         boolean current
) {
}
