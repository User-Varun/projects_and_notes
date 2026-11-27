package com.quickcommerce.engine.darkstore;

import com.quickcommerce.engine.darkstore.dto.AddDarkStoreRequest;
import com.quickcommerce.engine.darkstore.dto.AddDarkStoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dark-stores")
public class DarkStoreController {

    private final DarkStoreService darkStoreService;

    @PostMapping()
    public ResponseEntity<AddDarkStoreResponse> addDarkStore(@Valid @RequestBody AddDarkStoreRequest request){
        AddDarkStoreResponse res = darkStoreService.addDarkStore(request);
        return ResponseEntity.ok().body(res);
    }
}
