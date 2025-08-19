package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // READ ALL
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // READ ONE
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // PATCH
    @PatchMapping("/users/{id}")
    public User patchUser(@PathVariable Long id, @RequestBody User partialUser) {
        return userService.patchUser(id, partialUser);
    }

    // DELETE
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
