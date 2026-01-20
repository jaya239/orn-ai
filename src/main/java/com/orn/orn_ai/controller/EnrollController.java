package com.orn.orn_ai.controller;

import com.orn.orn_ai.dto.EnrollRequest;
import com.orn.orn_ai.dto.EnrollResponse;
import com.orn.orn_ai.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollForm")
@CrossOrigin(origins = "*")
public class EnrollController {

    @Autowired
    private EnrollService service;

    @PostMapping
    public ResponseEntity<EnrollResponse> submitEnroll(@Validated @RequestBody EnrollRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.submitEnrollForm(request));
    }
}

