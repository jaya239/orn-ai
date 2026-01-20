package com.orn.orn_ai.controller;

import com.orn.orn_ai.dto.SubscriberRequest;
import com.orn.orn_ai.dto.SubscriberResponse;
import com.orn.orn_ai.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
@CrossOrigin(origins = "*")
public class SubscriberController {

    @Autowired
    private SubscriberService service;

    @PostMapping
    public ResponseEntity<SubscriberResponse> submitSubscriber(@Validated @RequestBody SubscriberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.submitSubscriber(request));
    }
}
