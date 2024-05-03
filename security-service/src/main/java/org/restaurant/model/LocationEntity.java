package org.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LocationId;
    private String city;
    private String street;
    private String streetNumber;
    private String country;
    private String postalCode;
    private boolean current;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // This column will store the ID of the restaurant
    private UserCredentialEntity userCredential;
}
