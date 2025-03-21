package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.dto.LoginRequest;


@Service
public class AuthService {
	
	
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private final UserRepository userRepository;
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signUp(User user) {
        if (this.userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already in use!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
		return "User registered successfully!";
}
    
    public boolean validateLogin(LoginRequest loginRequest) {
        User user = this.userRepository.findByEmail(loginRequest.getEmail());
        // ✅ Check if user exists and password matches
        if (user != null &&  passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return true;
        }
        return false;
    }
}
