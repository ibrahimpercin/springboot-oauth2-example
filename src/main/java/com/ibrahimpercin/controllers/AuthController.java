package com.ibrahimpercin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping(value="/")
	public String auth() {
		return "Hello";
	}
	
	@GetMapping(value="/private")
	public String privateArea() {
		return "private";
	}
}
