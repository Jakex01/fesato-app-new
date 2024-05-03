package org.restaurant.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.restaurant.model.LocationEntity;
import org.restaurant.request.PostLocationRequest;
import org.restaurant.response.LocationResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T15:58:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationEntity locationRequestToLocationEntity(PostLocationRequest postLocationRequest) {
        if ( postLocationRequest == null ) {
            return null;
        }

        LocationEntity locationEntity = new LocationEntity();

        return locationEntity;
    }

    @Override
    public List<LocationResponse> locationEntityToLocationResponse(List<LocationEntity> locationEntity) {
        if ( locationEntity == null ) {
            return null;
        }

        List<LocationResponse> list = new ArrayList<LocationResponse>( locationEntity.size() );
        for ( LocationEntity locationEntity1 : locationEntity ) {
            list.add( locationEntityToLocationResponse1( locationEntity1 ) );
        }

        return list;
    }

    protected LocationResponse locationEntityToLocationResponse1(LocationEntity locationEntity) {
        if ( locationEntity == null ) {
            return null;
        }

        String city = null;
        String street = null;
        String streetNumber = null;
        String country = null;

        LocationResponse locationResponse = new LocationResponse( city, street, streetNumber, country );

        return locationResponse;
    }
}
