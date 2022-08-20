package com.example.demospring1.login.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private int id;
    private String firstname;
//    private int namsinh;
    private String lastname;
}
