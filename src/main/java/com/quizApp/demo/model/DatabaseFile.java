package com.quizApp.demo.model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class DatabaseFile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String fileName;

	private String fileType;
	
	private String description;

	@Lob
	private  byte[] data;
	
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public DatabaseFile() {

	}

	public DatabaseFile(String fileName, String fileType,  byte[] bs, String desc,Quiz quiz) {
		
		this.fileName = fileName;
		this.fileType = fileType;
		this.description= desc;
		this.data = bs;
		this.quiz=quiz;
	}

	public int getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public  byte[] getData() throws IOException {
		return data;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setData( byte[] file) {
		this.data = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
