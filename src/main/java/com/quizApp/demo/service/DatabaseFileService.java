package com.quizApp.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.quizApp.demo.model.DatabaseFile;


public interface DatabaseFileService {
	public DatabaseFile storeFile(MultipartFile file,String desc);
	
	public DatabaseFile getFile(Integer fileid);
	
	public List<DatabaseFile> getFiles();
}
