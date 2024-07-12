package com.poscodx.mysite;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*
 스프링 부트 톰캣 배포를 위한 설정
 */
public class BootInitializer extends SpringBootServletInitializer {
    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(MysiteApplication.class);
    }

}
