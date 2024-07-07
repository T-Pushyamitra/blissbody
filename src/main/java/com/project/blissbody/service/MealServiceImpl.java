package com.project.blissbody.service;

import com.project.blissbody.entity.Meal;
import com.project.blissbody.repository.MealRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MealServiceImpl implements MealService{

    @Autowired
    MealRepository mealRepository;

    @Override
    public List<Meal> index() {
        return mealRepository.findAll();
    }

    @Override
    public Meal get(ObjectId id) {
        return mealRepository.findById(id).orElse(null);
    }

    @Override
    public Meal save(Meal meal) {
        try{
            Meal Meal = mealRepository.save(meal);
            log.info("Saved ingredient {}", Meal.getId());
            return mealRepository.save(meal);
        } catch (Exception e){
            throw new RuntimeException("Failed on saving Meal " + e.getMessage());
        }
    }

    @Override
    public Meal update(ObjectId id, Meal meal) {
        Meal oldIngredient = mealRepository.findById(id).orElse(null);

        if (oldIngredient == null){
            log.error("Didn't find ingredient by id ${id}");
            throw new RuntimeException("Didn't find ingredient by id ${id}");
        }

        Meal updatedIngredient = mealRepository.save(meal);
        log.info("Updated ingredient {}", id);
        return updatedIngredient;
    }
}
