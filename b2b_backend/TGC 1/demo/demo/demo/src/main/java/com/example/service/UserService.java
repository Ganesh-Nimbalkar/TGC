package com.example.service;

import com.example.model.UserRegister;
import com.example.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    

    public ResponseEntity<?> register(UserRegister user) {
        if (user != null) {
            userRepository.save(user);
            return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }
    
   ////////////////////////////////////// 
    
//    public ResponseEntity<?> login(String username, String password){
//  	   
//  	   Optional<UserRegister> user = userRepository.findByusername(username);
//  	   
//  	   String passwordCheck = user.get().getPassword();
//  	   
//  	   if(user.isPresent()) {
//  		   
//  		   if(passwordCheck.equals(password)) {
//  			   return new ResponseEntity<> (user, HttpStatus.OK);
//  		   }
//  		   else {
//  			   return new ResponseEntity<> ("password incorrect", HttpStatus.BAD_REQUEST);
//  		   }
//  	   }
//  	   return new ResponseEntity<> ("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//  	   
//     }
    
    public ResponseEntity<?> login(String username, String password) {
        Optional<UserRegister> user = userRepository.findByusername(username);

        if (user.isPresent()) {
            String passwordCheck = user.get().getPassword();

            if (passwordCheck.equals(password)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password incorrect", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    
  
    public List<UserRegister> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> deleteUser(Long userId) {
        UserRegister user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateUser(Long userId, UserRegister updatedUser) {
        UserRegister user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setContactNumber(updatedUser.getContactNumber());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
