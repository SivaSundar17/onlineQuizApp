package com.quizApp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.model.QuizPaymentStatus;
import com.quizApp.demo.service.QuizPaymentStatusService;
import com.quizApp.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quizPaymentStatus")
public class QuizPaymentStatusController {
	
	@Autowired
	private QuizPaymentStatusService quizPaymentStatusSerrvice;

	@PostMapping("/")
	public ResponseEntity<QuizPaymentStatus> addPaymentStatus(@RequestBody QuizPaymentStatus quizPaymeantStatus){
		quizPaymentStatusSerrvice.addPaymentStatus(quizPaymeantStatus);
		return new ResponseEntity<>(quizPaymeantStatus, HttpStatus.OK);
		
	}
	
	@GetMapping("/paymentStatus/{user_id}/{quiz_id}")
	public QuizPaymentStatus getPaymentStatus(@PathVariable Long user_id,@PathVariable Long quiz_id){
		
	return quizPaymentStatusSerrvice.getQuizPaymentStatus(user_id, quiz_id);
		
	}
	
	@PutMapping("/{id}")
	public QuizPaymentStatus updatePaymentStatus(@PathVariable Long id,@RequestBody QuizPaymentStatus quizPaymeantStatus){
		
	return quizPaymentStatusSerrvice.updateQuizPaymentStatus(id,quizPaymeantStatus);
		
	}
	
	@DeleteMapping("/deleteStatus/{id}")
	public ResponseEntity<String> deleteQuizPaymentStatus(@PathVariable long id) {
		quizPaymentStatusSerrvice.delePaymentStatus(id);
		return new ResponseEntity<>("status deleted Successfully", HttpStatus.OK);
	}
	
}
