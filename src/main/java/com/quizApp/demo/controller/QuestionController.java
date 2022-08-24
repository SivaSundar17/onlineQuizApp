package com.quizApp.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.service.QuestionService;
import com.quizApp.demo.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

  //update the question
    @PutMapping("/update/{quesId}")
    public ResponseEntity<Question> update(@PathVariable long quesId , @RequestBody Question question) {
        return ResponseEntity.ok(this.service.updateQuestion(quesId,question));
    }

    //get all question of quiz
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
        Quiz quiz = new Quiz();
        quiz.setId(qid);
        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);

    }


    //get question by questionId
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId) {
        return this.service.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId) {
        this.service.deleteQuestion(quesId);
    }


}
