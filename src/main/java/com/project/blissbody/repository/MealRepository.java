package com.project.blissbody.repository;

import com.project.blissbody.entity.Meal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, ObjectId> {
}
