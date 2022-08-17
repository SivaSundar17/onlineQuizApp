package com.quizApp.demo.service;

import java.util.List;
import java.util.Set;


import com.quizApp.demo.model.User;
import com.quizApp.demo.model.UserRole;

public interface UserService {

	User getUser(String email);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	public String userLogin(String email,String password);
	
	
	public Set<User> getAllUsers();
}
