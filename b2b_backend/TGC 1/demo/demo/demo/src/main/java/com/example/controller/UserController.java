package com.example.controller;

import com.example.model.UserRegister;
import com.example.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegister user) {
        return userService.register(user);
    }
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody UserRegister user) {
//        
//        return ResponseEntity.ok(Map.of("message", "Registration Successful"));
//    }
    /////////////////////////
    @GetMapping("/login")
   	public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
   		return userService.login(username,password);
   	}

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRegister updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
