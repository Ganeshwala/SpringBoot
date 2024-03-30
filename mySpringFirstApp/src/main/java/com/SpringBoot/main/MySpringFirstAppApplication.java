package com.SpringBoot.main;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.SpringBoot.main.Entities.User;
import com.SpringBoot.main.dao.UserRepository;

@SpringBootApplication
public class MySpringFirstAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MySpringFirstAppApplication.class, args);
		
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		/*User user = new User();
		user.setUsername("Chintan Ganeshwla");
		user.setUserEmail("ganeshwala@gmail.com");
		user.setPassword("Chintan");
		 
		User save = userRepository.save(user);
		System.out.println(save.toString());*/
		
		Optional<User> userDetails = userRepository.findById((long)2);
		User user = userDetails.get();
		user.setUsername("Ganeshwc");
		user.setUserEmail("gmail@gmail.com");
		user.setPassword("qwerty");
		List<User> saveUser = List.of(user); // this is java9 method which return list of specific type 
		List<User> saveAll = userRepository.saveAll(saveUser); // to save multiple object in DB we need saveAll() which take list of object
		
		saveAll.forEach(u->{
			System.out.println(u.toString());
		});
		
		List<User> byUsername = userRepository.findByUsername("Ganeshwc");
		byUsername.forEach(u->System.out.println(u));
		
		User distinctByUsernameAndPassword = userRepository.findDistinctByUsernameAndPassword("Chintan Ganeshwala", "Chintan");
		System.out.println(distinctByUsernameAndPassword.toString());
		
	}

}
