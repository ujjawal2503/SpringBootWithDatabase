package com.example.one.dayOne.service;

import com.example.one.dayOne.dao.IUserService;
import com.example.one.dayOne.model.RegisterUser;
import com.example.one.dayOne.model.entity.RegisterUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class UserService {
    @Autowired
    IUserService iUserService;

    public String registerUser(RegisterUser registerUser) {
        boolean flag = iUserService.existsById(registerUser.getUserId());
        if (!flag) {
            RegisterUserEntity registerUserEntity = new RegisterUserEntity();
            registerUserEntity.setUserId(registerUser.getUserId());
            registerUserEntity.setName(registerUser.getName());
            registerUserEntity.setEmailAdd(registerUser.getEmailAdd());
            registerUserEntity.setPhoneNo(registerUser.getPhoneNo());
            registerUserEntity.setPassword(registerUser.getPassword());
            iUserService.save(registerUserEntity);
            return "Successfully registered";
        } else
            return "UserId already exist";

    }

    public String updateUser(RegisterUser registerUser) throws AccountNotFoundException {
        RegisterUserEntity registerUserEntity = iUserService.findById(registerUser.getUserId())
                .orElseThrow(() -> new AccountNotFoundException("UserId not found"));
        registerUserEntity.setPassword(registerUser.getPassword());
        registerUserEntity.setName(registerUser.getName());
        registerUserEntity.setEmailAdd(registerUser.getEmailAdd());
        registerUserEntity.setPhoneNo(registerUser.getPhoneNo());
        iUserService.save(registerUserEntity);
        return "update successfully";
    }

    public String deleteByUserId(Integer userId) throws AccountNotFoundException {

        boolean flag = iUserService.existsById(userId);
        if (flag) {
            RegisterUserEntity registerUserEntity = iUserService.findById(userId).get();
            iUserService.delete(registerUserEntity);
            return "Delete successfully done";
        } else {
            return "Userid doesn't exist";
        }
    }

    public Iterable<RegisterUserEntity> getAllUser() {
        return iUserService.findAll();
    }
}
