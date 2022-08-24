package com.quizApp.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.DatabaseFile;
import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {
	boolean existsByfileName(String fileName);

	DatabaseFile getByfileName(String fileName);
	
	Set<DatabaseFile> findByQuiz(Quiz quiz);


}
