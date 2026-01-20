package com.orn.orn_ai.service;

import com.orn.orn_ai.dto.FranchiseRequest;
import com.orn.orn_ai.dto.FranchiseResponse;
import com.orn.orn_ai.entity.Franchise;
import com.orn.orn_ai.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FranchiseService {

    @Autowired
    private FranchiseRepository repo;

    public FranchiseResponse submitFranchiseForm(FranchiseRequest request) {
        Franchise franchise = new Franchise();
        franchise.setFullname(request.getFullname());
        franchise.setEmail(request.getEmail());
        franchise.setPhone(request.getPhone());
        franchise.setAddress(request.getAddress());

        Franchise saved = repo.save(franchise);

        return FranchiseResponse.builder()
                .message("Franchise information submitted successfully!")
                .data(saved)
                .build();
    }
}

