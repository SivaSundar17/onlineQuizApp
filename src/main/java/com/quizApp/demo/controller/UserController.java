package com.quizApp.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.demo.model.Role;
import com.quizApp.demo.model.User;
import com.quizApp.demo.model.UserRole;
import com.quizApp.demo.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        roles.add(userRole);
        return this.userService.createUser(user, roles);
        
        
    }

    @PostMapping("/login")
    public String getUser(@RequestBody User user) {
    	return this.userService.userLogin(user.getEmail(), user.getPassword());
    }
    
    @GetMapping("/{email}")
    public User loginUser(@PathVariable("email") String email) {
        return this.userService.getUser(email);

    }
    
    @GetMapping("/getUsers")
    public Set<User> getUsers(){
    	
    	return this.userService.getAllUsers();
    }
    
    @GetMapping("getUser/{id}")
    public User getProfileById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }    
    
    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Long id,@RequestBody User userDetails)
    {

        return userService.updateUserById(id,userDetails);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id)
    {
    	this.userService.deleteUser(id);
    }


}
