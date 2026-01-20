package com.orn.orn_ai.repository;

import com.orn.orn_ai.entity.Franchise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends MongoRepository<Franchise, String> {}

