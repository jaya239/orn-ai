package com.orn.orn_ai.dto;

import com.orn.orn_ai.entity.Franchise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FranchiseResponse {
    private String message;
    private Franchise data;
}
