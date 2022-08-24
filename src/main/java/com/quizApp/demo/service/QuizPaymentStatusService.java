package com.quizApp.demo.service;

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.QuizPaymentStatus;

public interface QuizPaymentStatusService {
	
    public QuizPaymentStatus addPaymentStatus(QuizPaymentStatus quizPaymentStatus);
    
    public QuizPaymentStatus getQuizPaymentStatus(Long userId, long qid);
    
    public QuizPaymentStatus updateQuizPaymentStatus(Long id,QuizPaymentStatus quizPaymentStatus);
    public void delePaymentStatus(long id);
}
