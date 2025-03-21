package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import com.example.dto.LoginRequest;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	private final AuthService authService;
    public AuthController(AuthService authService) {
    	this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
    	try {
            String message = this.authService.signUp(user);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }		
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
    	System.out.println("Login Request : "+ loginRequest);
        boolean isValid = this.authService.validateLogin(loginRequest);
        if (isValid) {
            return "Login successful!";
        } else {
            return null;
        }
    }
}