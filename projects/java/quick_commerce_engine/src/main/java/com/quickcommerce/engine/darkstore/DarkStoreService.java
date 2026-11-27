package com.quickcommerce.engine.darkstore;

import com.quickcommerce.engine.darkstore.dto.AddDarkStoreRequest;
import com.quickcommerce.engine.customer.dto.GetNearestStoreRequest;
import com.quickcommerce.engine.darkstore.dto.AddDarkStoreResponse;
import com.quickcommerce.engine.darkstore.model.DarkStore;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DarkStoreService {

    private final DarkStoreRepository darkStoreRepository;

    public AddDarkStoreResponse addDarkStore(AddDarkStoreRequest request){
        DarkStore ds = new DarkStore();

        ds.setName(request.getName());
        ds.setActive(true);
        ds.setDeliveryRadiusMeters(request.getDeliveryRadiusMeters());
        ds.setLatitude(BigDecimal.valueOf(request.getLatitude()));
        ds.setLongitude(BigDecimal.valueOf(request.getLongitude()));

        DarkStore saved  = darkStoreRepository.save(ds);

        return new AddDarkStoreResponse(saved.getId());
    }


    public Optional<DarkStore> getNearestStore(@Valid @RequestBody GetNearestStoreRequest request){

        // for small no of darkstore loading each one is fine but for large no use the geospatial query
        return darkStoreRepository.findAll().stream()
                .filter(entry -> entry.getActive() == true)
                .map(store -> Map.entry(
                        store,
                        distanceInMeters(
                                request.getCustomerLatitude() ,
                                request.getCustomerLongitude(),
                                store.getLatitude().doubleValue() ,
                                store.getLongitude().doubleValue()
                        )
                ))
                .filter(entry -> entry.getValue() <= entry.getKey().getDeliveryRadiusMeters())
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }


    // used for internal use only
    public Optional<DarkStore> getNearestStore(double latitude , double longitude){

        // for small no of darkstore loading each one is fine but for large no use the geospatial query
        return darkStoreRepository.findAll().stream()
                .filter(entry -> entry.getActive() == true)
                .map(store -> Map.entry(
                        store,
                        distanceInMeters(
                                latitude ,
                                longitude,
                                store.getLatitude().doubleValue() ,
                                store.getLongitude().doubleValue()
                        )
                ))
                .filter(entry -> entry.getValue() <= entry.getKey().getDeliveryRadiusMeters())
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // using the Haversine formula
    private double distanceInMeters(double lat1 , double lng1 , double lat2 , double lng2){
        double earthRadiusMeters = 6_371_000;
        double latDifference = Math.toRadians(lat2 - lat1);
        double lngDifference = Math.toRadians(lng2 - lng1);

        double a = Math.sin(latDifference / 2) * Math.sin(latDifference / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lngDifference / 2) * Math.sin(lngDifference / 2);

        return earthRadiusMeters * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
