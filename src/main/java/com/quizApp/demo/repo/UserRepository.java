package com.quizApp.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizApp.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);

    @Query(value="SELECT *\r\n"
    		+ "FROM user,user_role\r\n"
    		+ "WHERE user_role.user_id=user.id AND user_role.role_role_id!=1",nativeQuery = true )
    public Set<User> fetchAllUsers();

}
