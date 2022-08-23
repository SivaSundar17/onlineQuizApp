package com.quizApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.DatabaseFile;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {
	boolean existsByfileName(String fileName);

	DatabaseFile getByfileName(String fileName);

}
