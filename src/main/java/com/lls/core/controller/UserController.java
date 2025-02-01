package com.lls.core.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<String> users = new ArrayList<>();

    // Get all users
    @GetMapping("/users")
    public List<String> getAllUsers() {
        return List.of("1", "2");
        // return users;
    }

    // Get a specific user by index
    @GetMapping("/users/{index}")
    public String getUser(@PathVariable int index) {
        return users.get(index);
    }

    // Add a new user
    @PostMapping("/users")
    public void addUser(@RequestBody String user) {
        users.add(user);
    }

    // Update an existing user
    @PutMapping("/users/{index}")
    public void updateUser(@PathVariable int index, @RequestBody String user) {
        users.set(index, user);
    }

    // Delete a user
    @DeleteMapping("/users/{index}")
    public void deleteUser(@PathVariable int index) {
        users.remove(index);
    }
}
