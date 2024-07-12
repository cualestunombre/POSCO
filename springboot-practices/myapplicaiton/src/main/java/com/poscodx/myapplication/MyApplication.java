package com.poscodx.myapplication;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootConfiguration
@EnableAutoConfiguration
// 테스트 클래스: 테스트 환경에서 스프링 애플리케이션의 설정을 정의할 때 사용
public class MyApplication{

	/*
	SpringApplication.run(...)에서 일어나는 일
	1. 어플리케이션 컨텍스트 (ApplicationContext, Spring Container) 생성
	2. 만약 웹어플리케이션이면 웹애플리케이션 타입을 결정(Spring MVC, Spring WebFlux)
	3. 어노테이션 스캐닝 + Configuration Class를 통해서 빈 생성/등록/와이어링 작업
	4. 만약 웹어플리케이션이고 타입이 Spring MVC 이면 Dispatcher Servlet이면
		- 내장 서버 인스턴스 생성 (TomcatEmbededServiceServletContainer)
		- 서버 인스턴스에 웹어플리케이션을 배포
		- 서버 인스턴스
	5. ApplicationRunner 인터페이스를 구현한 빈을 Application Context에서 찾아서 실행한다

	 */


	public static class MyComponent{

	}

	@Bean
	public MyComponent myComponent(){
		return new MyComponent();
	}


	public static void main(String[] args) {
		try(ConfigurableApplicationContext ac = SpringApplication.run(MyApplication.class);){
			MyComponent my = (MyComponent) ac.getBean(MyComponent.class);
		}
	}


	
	

}
