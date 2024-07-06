package com.project.blissbody.controller;


import com.project.blissbody.entity.Ingredients;
import com.project.blissbody.entity.Meal;
import com.project.blissbody.service.MealService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@Slf4j
public class MealController {

    @Autowired
    MealService mealService;

    @GetMapping
    public ResponseEntity<?> index(){
        try{
            List<Meal> meals = mealService.index();
            return new ResponseEntity<>(meals, HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMeal(@PathVariable("id") ObjectId id){
        try{
            Meal meal = mealService.get(id);

            if (meal == null){
                log.warn("No meal found by id ${id}");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(meal, HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Meal meal){
        try {
            if (meal.getIngredientsList().isEmpty()){
                log.error("Error occurred required at least one ingredient for a meal");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(mealService.save(meal), HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Error occurred while saving new meal: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Meal meal, @PathVariable("id")ObjectId id){
        try{
            if (id == null){
                log.error("Error occurred no id provided");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (meal.getIngredientsList().isEmpty()){
                log.error("Error occurred required at least one ingredient for a meal");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Meal updateMeal = mealService.update(id, meal);
            return new ResponseEntity<>(updateMeal, HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Error occurred while updating meal: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
