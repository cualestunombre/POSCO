package com.poscodx.tabbox.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class LandingController {
	
	@GetMapping
	public String index() {
		log.info("인덱스 페이지 출력");return "index";


	}
}