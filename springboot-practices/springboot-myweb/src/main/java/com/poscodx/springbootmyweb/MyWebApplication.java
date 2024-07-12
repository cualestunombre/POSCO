package com.poscodx.springbootmyweb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication


public class MyWebApplication {
    public static void main(String[] args){
        // context는 Closeable의 구현체이다
       ConfigurableApplicationContext context = SpringApplication.run(MyWebApplication.class,args);

    }
}
