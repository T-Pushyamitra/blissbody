package com.project.blissbody.service;

import com.project.blissbody.entity.Meal;
import org.bson.types.ObjectId;

import java.awt.*;
import java.util.List;

public interface MealService {

    public abstract List<Meal> index();
    public abstract Meal get(ObjectId id);
    public abstract Meal save(Meal meal);
    public abstract Meal update(ObjectId id, Meal meal);

}
