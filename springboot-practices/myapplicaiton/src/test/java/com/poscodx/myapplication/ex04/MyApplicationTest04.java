package com.poscodx.myapplication.ex04;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscodx.myapplication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ViewResolver;

import javax.sql.DataSource;

@SpringBootTest
public class MyApplicationTest04 {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ViewResolver viewResolver;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void test(){
        userRepository.loadUser();
        System.out.println(viewResolver);
        System.out.println(mapper);
    }

}
