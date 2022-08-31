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
		if(data==null) {
			return null;
		}
		if(password.equals(data.getPassword())) {
			Set<UserRole> ur=data.getUserRoles();
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

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stu
        return this.userRepository.findById(id).get();
	}

	@Override
	public User updateUserById(Long id, User userDetails) {
		// TODO Auto-generated method stub
		User Getuser=new User();
		Getuser=userRepository.findById(id).get();
		Getuser.setUsername(userDetails.getUsername());
		Getuser.setEmail(userDetails.getEmail());
		Getuser.setMobileNo(userDetails.getMobileNo());
		Getuser.setPassword(userDetails.getPassword());
		
		return userRepository.save(Getuser);
	}

	@Override
	public void deleteUser(long id) {
		this.userRepository.deleteById(id);
	}



}
