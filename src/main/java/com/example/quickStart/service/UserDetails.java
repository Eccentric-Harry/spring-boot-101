package com.example.quickStart.service;

import com.example.quickStart.model.User;
import com.example.quickStart.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetails {
    private final UserRepository userRepository;
    public UserDetails(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(String name){
        return userRepository.save(new User(null, name));
    }
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
}
