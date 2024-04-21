package com.springBoot.main.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.main.entities.LoginData;

import jakarta.validation.Valid;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginForm(Model model) {
		System.out.println("hello");
		model.addAttribute("loginInfo", new LoginData());
		System.out.println(":");
		return "loginPage";
	}
	
	@PostMapping("/submit")
	public String submitForm(@Valid @ModelAttribute("loginData")LoginData loginInfo,BindingResult result) {
		System.out.println("userName=>"+loginInfo.getUserName());
		if(result.hasErrors()) {
			System.out.println(result.toString()+"<======>");
			return "error";
		}
		return "loginPage";
	}
}
