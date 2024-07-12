package com.poscodx.springbootmyweb;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@SpringBootTest
public class MyTest {
    @Autowired
    ContentNegotiatingViewResolver viewResolver;

    @Test
    public void test(){
        viewResolver.getViewResolvers().forEach(System.out::println);
    }
}
