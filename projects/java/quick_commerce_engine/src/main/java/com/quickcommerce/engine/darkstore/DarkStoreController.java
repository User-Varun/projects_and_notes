package com.quickcommerce.engine.darkstore;

import com.quickcommerce.engine.darkstore.dto.AddDarkStoreRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dark-stores")
public class DarkStoreController {

    private DarkStoreService darkStoreService;

    @PostMapping
    public ResponseEntity<String> addDarkStore(@Valid @RequestBody AddDarkStoreRequest request){
        darkStoreService.addDarkStore(request);
        return ResponseEntity.ok().body("DarkStore added Successfully!");
    }
}
