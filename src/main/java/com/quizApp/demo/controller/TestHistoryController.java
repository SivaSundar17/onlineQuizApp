package com.quizApp.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.model.TestHistory;
import com.quizApp.demo.model.User;
import com.quizApp.demo.service.TestHistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/history")
public class TestHistoryController {
	
	@Autowired
	private TestHistoryService service;
	
	
	
	@PostMapping("/addhistory")
    public ResponseEntity<TestHistory> add(@RequestBody TestHistory testhistory) {
        return ResponseEntity.ok(this.service.addHistory(testhistory));
    }
	@GetMapping("/gethistory")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.service.getHistory());
    }

	 
	@GetMapping("/gettesthistory/{id}")
    public Set<TestHistory> gethistory(@PathVariable("id") Long id) {
		User user = new User();
        user.setId(id);
        return this.service.getTestHistory(user); 
    }
	 

	 

}

