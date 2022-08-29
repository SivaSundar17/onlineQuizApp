package com.quizApp.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table
@Entity
public class TestHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String quizTitle;
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date date;
//	private LocalDate localDate = LocalDate.now();
	@CreationTimestamp
	private LocalDateTime createdDate;
	private int marksGot;
	private int maxMarks;
	private int noOfQuestions;
	private int noOfQuestionsAttept;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
	@ManyToOne(fetch = FetchType.EAGER)
    private User user;

	public TestHistory() {}
	
	
	
	


	
	public TestHistory(Long id, String quizTitle, LocalDateTime createdDate, int marksGot, int maxMarks,
			int noOfQuestions, int noOfQuestionsAttept, Quiz quiz, User user) {
		super();
		this.id = id;
		this.quizTitle = quizTitle;
		this.createdDate = createdDate;
		this.marksGot = marksGot;
		this.maxMarks = maxMarks;
		this.noOfQuestions = noOfQuestions;
		this.noOfQuestionsAttept = noOfQuestionsAttept;
		this.quiz = quiz;
		this.user = user;
	}







	public String getQuizTitle() {
		return quizTitle;
	}



	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}


	


	public int getNoOfQuestions() {
		return noOfQuestions;
	}


	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}


	public int getNoOfQuestionsAttept() {
		return noOfQuestionsAttept;
	}


	public void setNoOfQuestionsAttept(int noOfQuestionsAttept) {
		this.noOfQuestionsAttept = noOfQuestionsAttept;
	}

	


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//public LocalDateTime getCreatedDate() {
	//		return createdDate;
	//	}
	public LocalDate getCreatedDate() {
		LocalDate tDate = createdDate.toLocalDate();
		return tDate;
}


//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate;
//	}



	//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
	
	public int getMarksGot() {
		return marksGot;
	}
	public void setMarksGot(int marksGot) {
		this.marksGot = marksGot;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}



}
