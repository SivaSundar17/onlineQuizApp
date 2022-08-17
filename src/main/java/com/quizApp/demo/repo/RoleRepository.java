package com.quizApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApp.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	

}
