package com.poscodx.myapplication.repository;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void loadUser(){
        System.out.println("loaded a user");
    }
}
