package com.example.quickStart.controller;

import com.example.quickStart.model.User;
import com.example.quickStart.service.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDetails userDetails;
    public UserController(UserDetails userDetails){
        this.userDetails = userDetails;
    }

    @GetMapping
    public List<User> allUsers(){
        return userDetails.getAllUsers();
    }

    @PostMapping("/add-user")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> body){
        String name = body.get("name");
        if (name == null) {
            return ResponseEntity.badRequest().build();
        }
        User user = userDetails.createUser(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        User user = userDetails.getUserById(id);
        if(user == null){
            return ResponseEntity.badRequest().build();
        }else{
            userDetails.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userDetails.getUserById(id);
        if(user == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }
}
