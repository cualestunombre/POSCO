package com.poscodx.myapplication.ex02;


import com.poscodx.myapplication.MyApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;


@SpringBootTest
public class MyApplicationTest02 {
    @Autowired
    MyApplication.MyComponent myComponent;


    @Test
    public void test(){
        System.out.println(myComponent);
    }




}
