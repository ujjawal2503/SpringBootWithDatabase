package com.example.one.dayOne.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterUser {

    private Integer userId;
    private String name;
    private String emailAdd;
    private String phoneNo;
    private String password;

}
