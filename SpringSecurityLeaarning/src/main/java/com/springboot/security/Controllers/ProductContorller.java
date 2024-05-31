package com.springboot.security.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.DTO.Product;
import com.springboot.security.Services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductContorller {

	@Autowired
	private ProductServices pServices;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome this endpoint is not secured";
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllProducts(){
		return pServices.getAllProduct();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return pServices.getProductId(id);
	}
}
