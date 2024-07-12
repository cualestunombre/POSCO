package com.poscodx.myapplication.event;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 애플리케이션이 시작된 후 실행할 코드
        System.out.println("애플리케이션 시작 완료!");
    }
}