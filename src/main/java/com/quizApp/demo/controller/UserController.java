package com.quizApp.demo.controller;

import java.util.HashSet;
import java.util.List;
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
    
    

//    @GetMapping("/getStudentId")
//    public String getStudentId(@RequestParam String userEmail) {
//        Query queryGetStudentIdOfAUser = entityManager.createNativeQuery("select student_id "
//                + "from students as s "
//                + "where s.student_email = :userEmail");
//
//        queryGetStudentIdOfAUser = queryGetStudentIdOfAUser.setParameter("userEmail", userEmail);
//
//        List result = queryGetStudentIdOfAUser.getResultList();
//
//        System.out.println("------------------------------------------");
//        System.out.println(result);
//        System.out.println("------------------------------------------");
//
//        entityManager.clear();
//        entityManager.close();
//
//        if (result.size() > 0) {
//            return result.get(0).toString();
//        }
//
//        return "null";
//    }

}
