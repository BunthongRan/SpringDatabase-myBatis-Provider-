package com.example.springdatabasemybatisproviders.controller;

import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import com.example.springdatabasemybatisproviders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/user")
@RestController
public class UserRestController {
    @Autowired
    UserService userService;
    @GetMapping("/all-users")
    public List<UserResponse> getAllUsers(){

        try{
            List<UserResponse> response = userService.getAllUsers();
            return response;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping("/new-user")
    public User addNewUsers(@RequestBody User user) {
        try {
            int affectedRow = userService.insertNewUser(user);
            System.out.println("Affected Row is :" + affectedRow);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            int affectedRow = userService.deleteUserById(id);
            System.out.println(affectedRow);
            return "delete successfully";
        } catch (Exception ex){
            ex.printStackTrace();
            return "fail to delete";
        }
    }

    @PatchMapping("/update-user/{id}")
    public String updateUser(@PathVariable int id , @RequestBody User user) {
        try {
            user.setId(id);
            int affectedRow = userService.updateUserById(user);
            System.out.println(affectedRow);
            return "Update successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Fail to update";
        }
    }

}
