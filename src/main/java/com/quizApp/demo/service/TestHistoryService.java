package com.quizApp.demo.service;

import java.util.Set;

import com.quizApp.demo.model.TestHistory;
import com.quizApp.demo.model.User;

public interface TestHistoryService {


	//getall
	public Set<TestHistory> getHistory();
	//post
	 public TestHistory addHistory(TestHistory testhistory);
	 //getbyuserid
	 public Set<TestHistory> getTestHistory(User user);
	
}

