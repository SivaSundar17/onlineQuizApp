package com.quizApp.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
	
	Set<Question> findByQuiz(Quiz quiz);
}
