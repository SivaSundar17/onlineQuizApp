package com.quizApp.demo.service;

import java.util.Set;

import com.quizApp.demo.model.Quiz;

public interface QuizService {
	public Set<Quiz> getQuizzes();
	public Quiz updateQuiz(Long id,Quiz quiz);
    public void deleteQuiz(Long id);
    public Quiz getQuiz(Long quizId);
    public Quiz addQuiz(Quiz quiz);
}
