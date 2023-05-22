package com.example.springdatabasemybatisproviders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username, gender, email, address, secretKey;
    private List<String> roles;



}
