package com.example.one.dayOne.controller;

import com.example.one.dayOne.model.RegisterUser;
import com.example.one.dayOne.model.entity.RegisterUserEntity;
import com.example.one.dayOne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUser registerUser) {
        return  userService.registerUser(registerUser);
    }

    @PutMapping("/update")
    public String updateDetails(@RequestBody RegisterUser registerUser) throws AccountNotFoundException {
        return  userService.updateUser(registerUser);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws AccountNotFoundException {
        return userService.deleteByUserId(userId);
    }

    @GetMapping("/getAll")
    public Iterable<RegisterUserEntity> getAllUser()
    {
        return  userService.getAllUser();
    }

}
