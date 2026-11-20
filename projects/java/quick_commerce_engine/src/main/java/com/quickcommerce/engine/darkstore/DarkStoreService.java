package com.quickcommerce.engine.darkstore;

import com.quickcommerce.engine.darkstore.dto.AddDarkStoreRequest;
import com.quickcommerce.engine.darkstore.model.DarkStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DarkStoreService {

    private DarkStoreRepository darkStoreRepository;

    public void addDarkStore(AddDarkStoreRequest request){
        DarkStore ds = new DarkStore();

        ds.setName(request.getName());
        ds.setActive(true);
        ds.setDeliveryRadiusMeters(request.getDeliveryRadiusMeters());
        ds.setLatitude(BigDecimal.valueOf(request.getLatitude()));
        ds.setLongitude(BigDecimal.valueOf(request.getLongitude()));

        darkStoreRepository.save(ds);
    }
}
