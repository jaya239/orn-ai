package com.orn.orn_ai.service;

import com.orn.orn_ai.dto.ContactRequest;
import com.orn.orn_ai.dto.ContactResponse;
import com.orn.orn_ai.entity.Contact;
import com.orn.orn_ai.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactResponse submitContact(ContactRequest request) {
        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setEmail(request.getEmail());
        contact.setMessage(request.getMessage());

        Contact saved = contactRepository.save(contact);

        return ContactResponse.builder()
                .message("Contact information submitted successfully!")
                .data(saved)
                .build();
    }
}

