package com.quizApp.demo.service;

import java.io.IOException;
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
    
    public void deleteFiles(Integer fileId);
	
	public void updateFiles(int fileId, MultipartFile file, String desc) throws IOException;
	
	public void updateDescription(int fileId, String desc);
}
