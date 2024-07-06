package com.project.blissbody.service;

import com.project.blissbody.entity.LoginRequest;
import com.project.blissbody.entity.UserProfile;
import com.project.blissbody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserManagementService {
    @Autowired
    private UserRepository usersRepo;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserProfile register(UserProfile registrationRequest){

        try {

            registrationRequest.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            UserProfile ourUsersResult = usersRepo.save(registrationRequest);
            if (ourUsersResult.getId() == null) {
                System.out.println("error");
            }
            return ourUsersResult;
        }catch (Exception e){
            return null;
        }
    }


    public UserProfile login(LoginRequest loginRequest){

        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
            UserProfile user = usersRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            user.setToken(jwt);
            user.setRole(user.getRole());
            user.setRefreshToken(refreshToken);
            return user;
        }catch (Exception e){
            return null;
        }
    }


    public UserProfile refreshToken(UserProfile refreshTokenRequest){
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenRequest.getToken());
            UserProfile users = usersRepo.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                users.setToken(jwt);
                users.setRefreshToken(refreshTokenRequest.getToken());
            }
            return users;

        }catch (Exception e){
            return null;
        }
    }
}
