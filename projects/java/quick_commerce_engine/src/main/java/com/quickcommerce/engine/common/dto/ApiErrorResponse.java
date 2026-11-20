package com.quickcommerce.engine.common.dto;

import java.time.Instant;

public record ApiErrorResponse(String code , String message , Instant timestamp) { }
