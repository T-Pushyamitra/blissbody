package com.project.blissbody.controller;

import com.project.blissbody.entity.LoginRequest;
import com.project.blissbody.entity.UserProfile;
import com.project.blissbody.service.UserManagementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

//https://howtodoinjava.com/spring-security/jwt-auth-vuejs-spring-boot-security/

@RestController
@RequestMapping("/auth")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/register")
    public ResponseEntity<UserProfile> register(@RequestBody UserProfile reg){
        try{
            UserProfile user = userManagementService.register(reg);

            if (user == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserProfile> login(@RequestBody LoginRequest user){
        try{
            UserProfile authenticatedUser = userManagementService.login(user);

            if (authenticatedUser == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserProfile> refreshToken(@RequestBody UserProfile user){
        return new ResponseEntity<>(userManagementService.refreshToken(user), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok("Logout successful");
    }
}
