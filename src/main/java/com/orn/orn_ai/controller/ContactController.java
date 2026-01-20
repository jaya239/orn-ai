package com.orn.orn_ai.controller;

import com.orn.orn_ai.dto.ContactRequest;
import com.orn.orn_ai.dto.ContactResponse;
import com.orn.orn_ai.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public ResponseEntity<ContactResponse> submitContact(@Validated @RequestBody ContactRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.submitContact(request));
    }
}

