package com.quizApp.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuizPaymentStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
//	private long quizId;
//	private long userId;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
    
    

	private boolean paymentStatus;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
    
}
