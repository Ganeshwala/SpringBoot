package com.spring.security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/normal")
	public ResponseEntity<String> getNormalUser(){
		return ResponseEntity.ok("yes I am normal user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> getAdminUser(){
		return ResponseEntity.ok("yes I am Adminl user");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> getUser(){
		return ResponseEntity.ok("yes I am Public");
	}
}
