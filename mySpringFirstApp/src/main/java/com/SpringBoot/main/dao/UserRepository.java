package com.SpringBoot.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.main.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUsername(String username);
	
	public User findDistinctByUsernameAndPassword(String name,String pass);
}
