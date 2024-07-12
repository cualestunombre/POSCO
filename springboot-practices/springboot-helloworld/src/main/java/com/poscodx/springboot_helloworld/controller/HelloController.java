package com.poscodx.springboot_helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@RequestMapping("/helloworld")
	public String helloWorld() {
		System.out.println("xxx");
		return "helloworld";
	}
}
