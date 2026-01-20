package com.orn.orn_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseRequest {

    @NotBlank(message = "Full name is required")
    private String fullname;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Phone is required")
    private Long phone;

    @NotBlank(message = "Address is required")
    private String address;
}

