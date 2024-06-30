package com.project.blissbody.entity;


import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "permission")
@Data
public class Permission {

    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String name;

    @NonNull
    private String description;

}
