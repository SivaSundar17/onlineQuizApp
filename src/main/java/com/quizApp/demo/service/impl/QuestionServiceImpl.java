package com.quizApp.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.repo.QuestionRepository;
import com.quizApp.demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{


    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(long quesId,Question question) {
		Question ques=new Question();
		ques=questionRepository.findById(quesId).get();
		ques.setQuesId(quesId);
		ques.setContent(question.getContent());
		ques.setOption1(question.getOption1());
		ques.setOption2(question.getOption2());
		ques.setOption3(question.getOption3());
		ques.setOption4(question.getOption4());
        return this.questionRepository.save(ques);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);
    }

}
