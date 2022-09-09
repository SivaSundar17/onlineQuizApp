package com.quizApp.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quizApp.demo.model.DatabaseFile;
import com.quizApp.demo.model.Quiz;
//import com.quizApp.demo.payload.Response;
import com.quizApp.demo.repo.DatabaseFileRepository;
import com.quizApp.demo.service.impl.DatabaseFileServiceImpl;

@CrossOrigin("*")
@RestController
public class DatabaseFileController {
	
	@Autowired
    private DatabaseFileServiceImpl fileStorageService;
	
	@PostMapping("/uploadFile")
    public DatabaseFile uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("desc") String desc, @RequestParam("qid") long qid) {
    	
    	Quiz quiz=new Quiz();
    	quiz.setId(qid);
    	DatabaseFile fileName = fileStorageService.storeFile(file,desc,quiz);
        return fileName;
    }
    
    //download file
    @GetMapping("/downloadFile/{fileid}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileid") Integer fileid, HttpServletRequest request) throws IOException {
        DatabaseFile databaseFile = fileStorageService.getFile(fileid);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
    }
//    
    @GetMapping("/files")
    public List<DatabaseFile> getAllFiles( ){
    	return fileStorageService.getFiles();
    }

    
    //delete file
    @DeleteMapping("/delete/{fileId}")
    public void deleteFile(@PathVariable int fileId) {
		fileStorageService.deleteFiles(fileId);
	}
	
    //update file
	@PutMapping("/update/{fileId}")
	public void updateFile(@PathVariable int fileId,@RequestParam("file") MultipartFile file,@RequestParam("desc") String desc) throws IOException {
		fileStorageService.updateFiles(fileId,file,desc);
	}
	
	@PutMapping("/updateDesc/{fileId}")
	public void updateFileDesc(@PathVariable int fileId,@RequestParam("desc") String desc) throws IOException {
		fileStorageService.updateDescription(fileId,desc);
	}
	@GetMapping("/files/{qid}")
    public Set<DatabaseFile> getAllFilesByQuizId(@PathVariable("qid") Long qId ){
        Quiz quiz = new Quiz();
        quiz.setId(qId);
    	return fileStorageService.getFilesOfQuiz(quiz);
    }
	
	
}
