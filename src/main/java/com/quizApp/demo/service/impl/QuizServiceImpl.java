package com.quizApp.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.repo.QuizRepository;
import com.quizApp.demo.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
    private QuizRepository quizRepository;

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepository.findAll());
	}
	 @Override
	  public Quiz updateQuiz(Long id,Quiz quiz) {
		    Quiz Getuser=new Quiz();
			Getuser=quizRepository.findById(id).get();
			Getuser.setTitle(quiz.getTitle());
			Getuser.setDescription(quiz.getDescription());
			Getuser.setMaxMarks(quiz.getMaxMarks());
			//Getuser.setNoOfQuestions(quiz.getNoOfQuestions());
			Getuser.setPrice(quiz.getPrice());
			
	        return this.quizRepository.save(Getuser);
	    }
	 
	 @Override
	    public void deleteQuiz(Long id) {
	        this.quizRepository.deleteById(id);
	    }
	 	
	 @Override
	    public Quiz getQuiz(Long id) {
	        return this.quizRepository.findById(id).get();
	    }
	@Override
	public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

}
