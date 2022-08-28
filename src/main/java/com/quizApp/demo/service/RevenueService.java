package com.quizApp.demo.service;

import java.time.LocalDateTime;
import java.util.Set;

import com.quizApp.demo.model.Revenue;

public interface RevenueService {
	
	public Revenue addRevenue(Revenue revenue);
	public Set<Revenue> getAllRevenues();
	public Revenue updateQuiz(Long id,Revenue revenue);
    public void deleteRevenue(Long id);
    public Revenue getRevenue(Long id);
    public Set<Revenue> getRevenuesByDate(LocalDateTime startDate,LocalDateTime endDate);
    public int getTotalRevenue();
}
