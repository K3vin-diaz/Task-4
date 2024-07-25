package com.intership.task_4.controller;


import com.intership.task_4.exception.ResourceNotFoundException;
import com.intership.task_4.model.UserModel;
import com.intership.task_4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-users")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/save-user")
    public UserModel createUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    @GetMapping({"id"})
    public ResponseEntity <UserModel> getUserById(@PathVariable  long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }


}
