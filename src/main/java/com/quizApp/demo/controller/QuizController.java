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
import com.quizApp.demo.repo.QuizRepository;
import com.quizApp.demo.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/addQuiz")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
	
	@GetMapping("/getQuiz")
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }
	@DeleteMapping("/deleteQuiz/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.quizService.deleteQuiz(id);
    }
	@PutMapping("/updateQuiz/{id}")
    public Quiz  update(@PathVariable Long id,@RequestBody Quiz quiz) {
        return quizService.updateQuiz(id,quiz);
    }

    //get single quiz
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable("id") Long id) {
        return this.quizService.getQuiz(id);
    }
	

}
