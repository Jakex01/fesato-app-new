package org.restaurant.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private Long LocationId;
    private String city;
    private String street;
    private String streetNumber;
    private String country;
    private String postalCode;
    private boolean current;
}
