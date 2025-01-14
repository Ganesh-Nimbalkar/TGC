package com.example.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;



@Service
public class UserService{
	
	@Autowired
	
	private UserRepository userRepository;


	
//	public ResponseEntity<?> saveUser(User user) {
//		
//		if(user != null) {
//			return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
//		}
//		return new ResponseEntity<>("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//	

	
	public ResponseEntity<?> saveUser(User user) {
        
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return new ResponseEntity<>("User is already registered with this email", HttpStatus.CONFLICT);
        }

        if (user != null) {
//          return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        	userRepository.save(user);
            return new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	

	public ResponseEntity<?> login(String email, String password){
		   
		   Optional<User> user = userRepository.findByEmail(email);
		   
		   String passwordCheck = user.get().getPassword();
		   
		   if(user.isPresent()) {
			   
			   if(passwordCheck.equals(password)) {
				   return new ResponseEntity<> (user, HttpStatus.OK);
			   }
			   else {
				   return new ResponseEntity<> ("password incorrect", HttpStatus.BAD_REQUEST);
			   }
		   }
		   return new ResponseEntity<> ("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		   
	   }

}