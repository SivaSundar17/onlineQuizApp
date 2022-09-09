package com.quizApp.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.QuizPaymentStatus;
import com.quizApp.demo.repo.QuestionRepository;
import com.quizApp.demo.repo.QuizPaymentStatusRepository;
import com.quizApp.demo.service.QuizPaymentStatusService;

@Service
public class QuizPaymentStatusServiceImpl implements QuizPaymentStatusService {
	
    @Autowired
    private QuizPaymentStatusRepository quizPaymentStatusRepository;

	@Override
	public QuizPaymentStatus addPaymentStatus(QuizPaymentStatus quizPaymentStatus) {
		
		// TODO Auto-generated method stub
		return quizPaymentStatusRepository.save(quizPaymentStatus) ;
	}

	@Override
	public QuizPaymentStatus getQuizPaymentStatus(Long userId, long qid) {
		// TODO Auto-generated method stub
		return quizPaymentStatusRepository.findByUserIdAndQuizId(userId, qid);
	}

	@Override
	public QuizPaymentStatus updateQuizPaymentStatus(Long id,QuizPaymentStatus quizPaymentStatus) {
		// TODO Auto-generated method stub
		QuizPaymentStatus qps=new QuizPaymentStatus();
		qps=this.quizPaymentStatusRepository.findById(id).get();
		qps.setId(id);
		qps.setPaymentStatus(quizPaymentStatus.isPaymentStatus());
//		qps.setQuiz(qps.getQuiz());
//		qps.setUser(qps.getUser());
		qps.setQuiz(qps.getQuiz());
		qps.setUser(qps.getUser());
        return this.quizPaymentStatusRepository.save(qps);

	}

	@Override
	public void delePaymentStatus(long id) {
		QuizPaymentStatus qps=new QuizPaymentStatus();
	        qps.setId(id);	
		this.quizPaymentStatusRepository.delete(qps);
		// TODO Auto-generated method stub
		
	}
	
	
	

}
