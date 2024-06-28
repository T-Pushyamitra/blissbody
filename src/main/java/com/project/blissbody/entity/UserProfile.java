package com.project.blissbody.entity;

import com.project.blissbody.Enum.Genders;
import lombok.*;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_profile")
@Data
public class UserProfile {

    @Id
    private ObjectId id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private Integer age;

    @NonNull
    private Genders gender;

    private Double height;

    private Double weight;

    private String activityLevel;


    private Double goalWeight;

    private Double bmi;

    @NonNull
    @Indexed(unique = true)
    public String username;

    @NonNull
    public String password;

    @NonNull
    @DBRef
    public Role role;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedDate
    private LocalDateTime updatedAt;

}

