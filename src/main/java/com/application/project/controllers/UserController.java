package com.application.project.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.project.models.User;
import com.application.project.services.UserServices;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServices userServices = new UserServices();


    @GetMapping("/users")
    public List<User> getUsers(int page) {
        return userServices.getUsers(page);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userServices.getUserById(id);
    }

    @RequestMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        return ResponseEntity.ok(userServices.createUser(newUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userToUpdate) {
        User updatedUser = userServices.updateUser(id, userToUpdate);
        return ResponseEntity.ok(updatedUser);
    }

}
