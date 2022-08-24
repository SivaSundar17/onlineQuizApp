package com.quizApp.demo.service;

import java.util.Set;

import com.quizApp.demo.model.Question;
import com.quizApp.demo.model.Quiz;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(long quesId,Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

//    public Question get(Long questionsId);
}
