package com.project.blissbody.service;

import com.project.blissbody.entity.Ingredients;
import com.project.blissbody.repository.IngredientsRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class IngredientsServiceImpl implements IngredientsService{

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Override
    public List<Ingredients> index() {
        return ingredientsRepository.findAll();
    }

    @Override
    public Ingredients get(ObjectId id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredients save(Ingredients ingredient) {
        try{
            Ingredients ingredients = ingredientsRepository.save(ingredient);
            log.info("Saved ingredient {}", ingredients.getId());
            return ingredientsRepository.save(ingredient);
        } catch (Exception e){
            throw new RuntimeException("Failed on saving ingredients " + e.getMessage());
        }
    }

    @Override
    public Ingredients update(ObjectId id, Ingredients ingredient) {
        Ingredients oldIngredient = ingredientsRepository.findById(id).orElse(null);

        if (oldIngredient == null){
            log.error("Didn't find ingredient by id ${id}");
            throw new RuntimeException("Didn't find ingredient by id ${id}");
        }

        Ingredients updatedIngredient = ingredientsRepository.save(ingredient);
        log.info("Updated ingredient {}", id);
        return updatedIngredient;
    }
}
