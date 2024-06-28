package com.project.blissbody.entity;


import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "role")
@Data
public class Role {

    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String name;

    @NonNull
    private String description;

    @NonNull
    @DBRef
    private List<String> permission;
}
