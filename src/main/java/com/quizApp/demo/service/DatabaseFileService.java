package com.quizApp.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.quizApp.demo.model.DatabaseFile;
import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;


public interface DatabaseFileService {
	
	public DatabaseFile storeFile(MultipartFile file,String desc,Quiz quiz);
	
	public DatabaseFile getFile(Integer fileid);
	
	public List<DatabaseFile> getFiles();
	
    public Set<DatabaseFile> getFilesOfQuiz(Quiz quiz);

}
