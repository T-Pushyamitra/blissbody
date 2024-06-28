package com.project.blissbody.entity;


import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredients")
@Data
public class Ingredients {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String name;

    private String brand;

    @NonNull
    private Double calories;

    @NonNull
    private Double protein;

    @NonNull
    private Double carbohydrates;

    @NonNull
    private Double fats;

    @NonNull
    private Double fiber;

    private Double sugar;

    private Double sodium;

}

