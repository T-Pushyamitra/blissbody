package com.project.blissbody.repository;

import com.project.blissbody.entity.Ingredients;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientsRepository extends MongoRepository<Ingredients, ObjectId> {

}
