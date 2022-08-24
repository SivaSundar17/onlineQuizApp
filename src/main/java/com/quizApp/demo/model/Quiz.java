package com.quizApp.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {
	@Id
//	@Column(nullable =false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
//	@Column(name="title" ,nullable =false)
	private String title;
	@Lob
//	@Column(name="description" ,nullable =false)
	private String description;
//	@Column(name="maxMarks" ,nullable =false)
	private String maxMarks;
//	@Column(name="noOfQuestions" ,nullable =false)
	private String noOfQuestions;
//	@Column(name="price" ,nullable =false)
	private int price;
	
	
	
	   @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<Question> questions = new HashSet<>();
	   
	   @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<QuizPaymentStatus> quizPaymentStatus = new HashSet<>();
	   
	   @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
	    private Set<DatabaseFile> dataBaseFile = new HashSet<>();
	   
	public Set<DatabaseFile> getDataBaseFile() {
		return dataBaseFile;
	}

	public void setDataBaseFile(Set<DatabaseFile> dataBaseFile) {
		this.dataBaseFile = dataBaseFile;
	}

	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(String noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Quiz(String title, String description, String maxMarks, String noOfQuestions, int price) {
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQuestions = noOfQuestions;
		this.price = price;
	}
	
	
	public Quiz() {
		
	}
	
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
	
	
	
}
