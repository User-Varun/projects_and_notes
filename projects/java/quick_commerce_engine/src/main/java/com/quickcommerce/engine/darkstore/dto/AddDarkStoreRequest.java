package com.quickcommerce.engine.darkstore.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddDarkStoreRequest {

    @NotNull
    private String name;


    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;

    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;

    @NotNull
    @Min(100)
    @Max(5000)
    private Integer deliveryRadiusMeters;
}
