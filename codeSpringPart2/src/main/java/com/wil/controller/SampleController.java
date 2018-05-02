package com.wil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello Wordld";
	}

}
