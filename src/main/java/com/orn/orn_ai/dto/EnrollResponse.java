package com.orn.orn_ai.dto;

import com.orn.orn_ai.entity.EnrollForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollResponse {
    private String message;
    private EnrollForm data;
}

