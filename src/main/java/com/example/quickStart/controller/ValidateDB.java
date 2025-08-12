package com.example.quickStart.controller;

import com.example.quickStart.model.User;
import com.example.quickStart.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ValidateDB {
    private final UserRepository repo;
    public ValidateDB(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping("/health")
    public ArrayList<User> getAllUsers(){
        List<User> users = repo.findAll();
        if(users.isEmpty()){
            return new ArrayList<>();
        }else{
            return new ArrayList<>(users);
        }
    }
}