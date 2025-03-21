package com.example.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getPassword() {
    	return this.password;
    }
}