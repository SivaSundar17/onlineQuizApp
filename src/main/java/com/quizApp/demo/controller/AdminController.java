package com.quizApp.demo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.demo.model.Role;
import com.quizApp.demo.model.User;
import com.quizApp.demo.model.UserRole;
import com.quizApp.demo.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	 @Autowired
	 private UserService userService;
	 
	 @PostMapping("/signup") 
	 public User createUser(@RequestBody User user) throws Exception{
	     Set<UserRole> roles=new HashSet<>();
	     Role role=new Role();
	     role.setRoleId(1L);
	     role.setRoleName("ADMIN");

	     UserRole userRole=new UserRole();
	     userRole.setRole(role);
	     userRole.setUser(user);
	     roles.add(userRole);
	     return this.userService.createUser(user, roles);
	   }
	 
	   @GetMapping("/{email}")
	   public User getUser(@PathVariable("email") String email){
	       return this.userService.getUser(email);

	   }
	   

}
