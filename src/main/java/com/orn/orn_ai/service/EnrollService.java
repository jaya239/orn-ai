package com.orn.orn_ai.service;

import com.orn.orn_ai.dto.EnrollRequest;
import com.orn.orn_ai.dto.EnrollResponse;
import com.orn.orn_ai.entity.EnrollForm;
import com.orn.orn_ai.repository.EnrollFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrollService {

    @Autowired
    private EnrollFormRepository repo;

    public EnrollResponse submitEnrollForm(EnrollRequest request) {
        EnrollForm form = new EnrollForm();
        form.setName(request.getName());
        form.setEmail(request.getEmail());
        form.setContact(request.getContact());

        EnrollForm saved = repo.save(form);

        return EnrollResponse.builder()
                .message("Enroll form submitted successfully!")
                .data(saved)
                .build();
    }
}

