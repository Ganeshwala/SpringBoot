package com.springBoot.main.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LoginData {
	
	@NotBlank(message = "userName cannot to blank")
	@Size(min = 3,max = 5,message = "User Name must be between 3 to 5 characters")
	private String userName;
	private String userEmail;
	private String password;
	
	
}
