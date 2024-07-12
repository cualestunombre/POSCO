package com.poscodx.myapplication.ex03;


import com.poscodx.myapplication.MyApplication;
import com.poscodx.myapplication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyApplicationTest03 {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.loadUser();
    }

}
