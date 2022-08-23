package com.quizApp.demo.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.quizApp.demo.exception.FileNotFoundException;
import com.quizApp.demo.exception.FileStorageException;
import com.quizApp.demo.model.DatabaseFile;
import com.quizApp.demo.repo.DatabaseFileRepository;
import com.quizApp.demo.service.DatabaseFileService;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService {

	@Autowired
    private DatabaseFileRepository dbFileRepository;
	
	@Override
    public DatabaseFile storeFile(MultipartFile file,String desc) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(),desc);

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
	
	public String updateFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            if(dbFileRepository.existsByfileName(fileName)) {
            	DatabaseFile dbFile_org = dbFileRepository.getByfileName(fileName);
            	dbFile_org.setFileName(fileName);
            	dbFile_org.setFileType(file.getContentType());
            	dbFile_org.setData(file.getBytes());
            	dbFileRepository.saveAndFlush(dbFile_org);
            	return "file updated";
            }
            return "file not updated";
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
