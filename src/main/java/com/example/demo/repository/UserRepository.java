package com.example.demo.repository;


import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.demo.model.User;

@Repository
public interface UserRepository extends CosmosRepository<User,String> {
	User findByEmail(String email);
}
