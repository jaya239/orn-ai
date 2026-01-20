package com.orn.orn_ai.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private Map<String, String> errors;
}
