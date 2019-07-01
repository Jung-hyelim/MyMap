package com.jhl.mymap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@GetMapping("/")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello")
	public String hello2() {
		return "hello2";
	}
}
