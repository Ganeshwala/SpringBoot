package com.SpringBoot.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.main.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUsername(String username);
	
	public User findDistinctByUsernameAndPassword(String name,String pass);
	
	@Query("from User")
	public List<User> getUser();
	
	@Query("select u.userEmail from User u where u.username =:name")
	public String getUserPassowrd(@Param(value = "name") String uName);
}
