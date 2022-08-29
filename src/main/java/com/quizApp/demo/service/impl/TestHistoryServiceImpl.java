package com.quizApp.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.TestHistory;
import com.quizApp.demo.model.User;
import com.quizApp.demo.repo.TestHistoryRepository;
import com.quizApp.demo.service.TestHistoryService;

@Service
public class TestHistoryServiceImpl implements TestHistoryService {
	@Autowired
	private TestHistoryRepository repo;

	@Override
    public TestHistory addHistory(TestHistory testhistory) {
        return this.repo.save(testhistory);
    }
	@Override
	public Set<TestHistory> getHistory() {
		return new HashSet<>(this.repo.findAll());
	}
	@Override
	public Set<TestHistory> getTestHistory(User user) {
		 return this.repo.findByUserOrderByIdDesc(user);
		
	}

}
