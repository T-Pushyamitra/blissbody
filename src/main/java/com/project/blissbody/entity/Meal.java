package com.project.blissbody.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Document(collection = "meal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String name;

    private String description;

    @NonNull
    @DBRef
    private List<Ingredients> ingredientsList;

}
