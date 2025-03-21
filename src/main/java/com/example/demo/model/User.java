package com.example.demo.model;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "users")  // Use lowercase "users"
public class User {
    
    @Id
    private String id;

    private String name;

    @PartitionKey  // Cosmos DB requires a partition key
    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}