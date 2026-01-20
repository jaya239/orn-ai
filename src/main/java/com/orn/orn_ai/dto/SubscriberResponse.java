package com.orn.orn_ai.dto;

import com.orn.orn_ai.entity.Subscriber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriberResponse {
    private String message;
    private Subscriber data;
}
