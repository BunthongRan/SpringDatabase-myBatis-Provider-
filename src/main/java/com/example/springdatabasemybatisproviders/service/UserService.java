package com.example.springdatabasemybatisproviders.service;

import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserResponse> getAllUsers();
    int insertNewUser(User user);
    public int deleteUserById(int id);
    public int updateUserById(User user);
}
