package com.project.blissbody.service;

import com.project.blissbody.entity.Ingredients;
import com.project.blissbody.repository.IngredientsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientsService {

    public abstract List<Ingredients> index();
    public abstract Ingredients get(ObjectId id);
    public abstract Ingredients save(Ingredients ingredient);
    public abstract Ingredients update(ObjectId id, Ingredients ingredient);

}
