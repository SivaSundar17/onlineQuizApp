package com.quizApp.demo.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.quizApp.demo.exception.FileNotFoundException;
import com.quizApp.demo.exception.FileStorageException;
import com.quizApp.demo.model.DatabaseFile;
import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.repo.DatabaseFileRepository;
import com.quizApp.demo.service.DatabaseFileService;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService {

	@Autowired
    private DatabaseFileRepository dbFileRepository;
	
	@Override
	public DatabaseFile storeFile(MultipartFile file, String desc, Quiz quiz) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(),desc,quiz);

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
	
	@Override
    public DatabaseFile getFile(Integer fileid) {
        return dbFileRepository.findById(fileid)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileid));
    }
    
	@Override
    public List<DatabaseFile> getFiles() {
    	
        return dbFileRepository.findAll();
    }
	
	
	public DatabaseFile updateFile(DatabaseFile databaseFile) {
		return this.dbFileRepository.save(databaseFile);
	}
	
	

	@Override
	public Set<DatabaseFile> getFilesOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
	return this.dbFileRepository.findByQuiz(quiz);
	}
	
	@Override
	public void deleteFiles(Integer fileId) {
		DatabaseFile dbFile=this.dbFileRepository.findById(fileId).get();
		this.dbFileRepository.delete(dbFile);
	}
	
	@Override
	public void updateFiles(int fileId, MultipartFile file, String desc) throws IOException {
		DatabaseFile dbFile = this.dbFileRepository.findById(fileId).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		byte [] byteArr=file.getBytes();
		dbFile.setData(byteArr);
		dbFile.setFileName(fileName);
		dbFile.setId(fileId);
		dbFile.setDescription(desc);
		dbFile.setFileType(file.getContentType());
		dbFileRepository.save(dbFile);
		
	}
	
	@Override
	public void updateDescription(int fileId, String desc) {
		DatabaseFile dbFile = this.dbFileRepository.findById(fileId).get();
		dbFile.setId(fileId);
		dbFile.setDescription(desc);
		dbFileRepository.save(dbFile);
	}

}
