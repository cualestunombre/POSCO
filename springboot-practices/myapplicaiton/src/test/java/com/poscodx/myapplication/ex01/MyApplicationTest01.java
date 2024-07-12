package com.poscodx.myapplication.ex01;


import com.poscodx.myapplication.MyApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyApplication.class})
public class MyApplicationTest01 {
    @Autowired
    MyApplication.MyComponent myComponent;

    @Test
    public void test(){
        System.out.println(myComponent);
    }




}
