package com.quizApp.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Revenue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private int amount;
	

	@CreationTimestamp
    private LocalDateTime date;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;
  
  @ManyToOne(fetch = FetchType.EAGER)
  private Quiz quiz;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public LocalDate getDate() {
	LocalDate tDate = date.toLocalDate();
	return tDate;
}

public void setDate(LocalDateTime date) {
	this.date = date;
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

public Revenue(long id,int amount, LocalDateTime date, User user, Quiz quiz) {
	super();
	this.id = id;
	this.amount=amount;
	this.date = date;
	this.user = user;
	this.quiz = quiz;
}

public Revenue() {
	super();
}



  
  
  
  
	
}
