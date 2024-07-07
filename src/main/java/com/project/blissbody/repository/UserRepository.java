package com.project.blissbody.repository;

import com.project.blissbody.entity.Ingredients;
import com.project.blissbody.entity.UserProfile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserProfile, ObjectId> {
    Optional<UserProfile> findByEmail(String email);
}
