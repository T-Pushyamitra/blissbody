package com.project.blissbody.entity;

import com.project.blissbody.Enum.Genders;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "user")
@Data
public class UserProfile implements UserDetails {

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

    @NonNull
    @Indexed(unique = true)
    public String email;

    @NonNull
    public String password;

    @NonNull
    public String role;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedDate
    private LocalDateTime updatedAt;

    private String token;

    private String refreshToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

