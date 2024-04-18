package com.SpringBoot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcomePage() {
		return "home";
	}
	
	@GetMapping("/done")
	public void done() {
		System.out.println("testing");
	}
}
