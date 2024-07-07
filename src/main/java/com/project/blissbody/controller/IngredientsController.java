package com.project.blissbody.controller;


import com.project.blissbody.entity.Ingredients;
import com.project.blissbody.service.IngredientsService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@Slf4j
public class IngredientsController {

    @Autowired
    IngredientsService ingredientsService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public ResponseEntity<?> index(){
        try{
            List<Ingredients> foodItemList = ingredientsService.index();
            return new ResponseEntity<>(foodItemList, HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public ResponseEntity<?> getIngredient(@PathVariable("id") ObjectId id){
        try{
            Ingredients ingredient = ingredientsService.get(id);

            if (ingredient == null){
                log.warn("No ingredient found by id ${id}");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ingredient, HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> save(@RequestBody Ingredients ingredients){
        try {
            return new ResponseEntity<>(ingredientsService.save(ingredients), HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Error occurred while saving new ingredient: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@RequestBody Ingredients ingredient, @PathVariable("id")ObjectId id){
        try{
            if (id != null) {
                Ingredients updateIngredient = ingredientsService.update(id, ingredient);
                return new ResponseEntity<>(updateIngredient, HttpStatus.CREATED);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("Error occurred while updating ingredient: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
