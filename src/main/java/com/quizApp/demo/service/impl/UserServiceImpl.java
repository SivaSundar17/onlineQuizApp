package com.quizApp.demo.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.Role;
import com.quizApp.demo.model.User;
import com.quizApp.demo.model.UserRole;
import com.quizApp.demo.repo.RoleRepository;
import com.quizApp.demo.repo.UserRepository;
import com.quizApp.demo.repo.UserRolesRepository;
import com.quizApp.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	 @Autowired
	 private UserRepository userRepository;
	    
	 @Autowired
	 private RoleRepository roleRepository;
	 
	 @Autowired
	 private UserRolesRepository userRolesRepository;

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User local=this.userRepository.findByEmail(user.getEmail());

        if(local!=null) {
        	System.out.println("User already present");
        }
        else{
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            
            local=this.userRepository.save(user);

        }
		return local;
	}
	
	@Override
	public String userLogin(String email,String password) {
		// TODO Auto-generated method stub;
		User data;
		String roleName = null;
		data=this.userRepository.findByEmail(email);
		Set<UserRole> ur=data.getUserRoles();
		if(password.equals(data.getPassword())) {
		for(UserRole val : ur) {
		      Role role=val.getRole();
		      roleName=role.getRoleName();
		    }	
			return roleName;
		}
		
			return "invalid";
	}
	
	@Override
	public Set<User> getAllUsers(){
		return userRepository.fetchAllUsers();
	}



}
