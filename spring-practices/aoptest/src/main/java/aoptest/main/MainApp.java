package aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aoptest.service.ProductService;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		
		ProductService ps = (ProductService) ac.getBean("productService");
		System.out.println(ps.find("abcdefg"));
		
		

	}

}
