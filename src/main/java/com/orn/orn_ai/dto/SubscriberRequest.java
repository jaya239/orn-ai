package com.orn.orn_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberRequest {

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
}

