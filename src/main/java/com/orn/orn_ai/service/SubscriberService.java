package com.orn.orn_ai.service;

import com.orn.orn_ai.dto.SubscriberRequest;
import com.orn.orn_ai.dto.SubscriberResponse;
import com.orn.orn_ai.entity.Subscriber;
import com.orn.orn_ai.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubscriberService {

    @Autowired
    private SubscriberRepository repo;

    public SubscriberResponse submitSubscriber(SubscriberRequest request) {
        Subscriber sub = new Subscriber();
        sub.setEmail(request.getEmail());

        Subscriber saved = repo.save(sub);

        return SubscriberResponse.builder()
                .message("Subscriber information submitted successfully!")
                .data(saved)
                .build();
    }
}

