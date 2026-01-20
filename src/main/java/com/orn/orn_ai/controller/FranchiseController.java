package com.orn.orn_ai.controller;

import com.orn.orn_ai.dto.FranchiseRequest;
import com.orn.orn_ai.dto.FranchiseResponse;
import com.orn.orn_ai.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franchiseForm")
@CrossOrigin(origins = "*")
public class FranchiseController {

    @Autowired
    private FranchiseService service;

    @PostMapping
    public ResponseEntity<FranchiseResponse> submitFranchise(@Validated @RequestBody FranchiseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.submitFranchiseForm(request));
    }
}

