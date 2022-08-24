package com.quizApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.model.QuizPaymentStatus;
import com.quizApp.demo.model.User;

@Repository
public interface QuizPaymentStatusRepository extends JpaRepository<QuizPaymentStatus,Long> {
	
    public QuizPaymentStatus findByUserIdAndQuizId(long user_id,long quiz_id );

}
