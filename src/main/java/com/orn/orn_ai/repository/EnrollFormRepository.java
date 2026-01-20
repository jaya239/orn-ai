package com.orn.orn_ai.repository;

import com.orn.orn_ai.entity.EnrollForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollFormRepository extends MongoRepository<EnrollForm, String> {}

