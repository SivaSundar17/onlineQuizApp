package com.quizApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizApp.demo.model.UserRole;

public interface UserRolesRepository extends JpaRepository<UserRole,Long> {

}
