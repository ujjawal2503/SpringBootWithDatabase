package com.example.one.dayOne.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@ToString
@Entity
public class RegisterUserEntity {

    @Id
    private Integer userId;
    private String name;
    private String emailAdd;
    private String phoneNo;
    private String password;
}
