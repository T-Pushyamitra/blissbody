package com.project.blissbody.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
@Data
public class LoginRequest {

    @NonNull
    @Indexed(unique = true)
    public String email;

    @NonNull
    public String password;
}
