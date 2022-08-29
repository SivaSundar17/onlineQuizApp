package com.quizApp.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.model.Revenue;
import com.quizApp.demo.repo.RevenueRepository;
import com.quizApp.demo.service.RevenueService;

@Service
public class RevenueServiceImpl implements RevenueService {
	
	@Autowired
	RevenueRepository revenueRepository;
	
	int total=0;

	@Override
	public Set<Revenue> getAllRevenues() {
		// TODO Auto-generated method stub
		return  new HashSet<>(this.revenueRepository.findAll());
	}

	@Override
	public Revenue updateQuiz(Long id, Revenue revenue) {
		// TODO Auto-generated method stub

		Revenue rev=new Revenue();
		rev=this.revenueRepository.findById(id).get();
		rev.setId(id);
		//rev.setDate(revenue.getDate());
//		rev.setAmount(revenue.getAmount());
		return this.revenueRepository.save(rev);
	}

	@Override
	public void deleteRevenue(Long id) {
		// TODO Auto-generated method stub
		this.revenueRepository.deleteById(id);
		
	}

	@Override
	public Revenue getRevenue(Long id) {
		// TODO Auto-generated method stub
		return this.revenueRepository.findById(id).get();
	}

	@Override
	public Revenue addRevenue(Revenue revenue) {
		// TODO Auto-generated method stub
		return this.revenueRepository.save(revenue);
	}

	@Override
	public Set<Revenue> getRevenuesByDate(LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return this.revenueRepository.findByDate(startDate, endDate);
	}

	@Override
	public int getTotalRevenue() {
		// TODO Auto-generated method stub
		return this.revenueRepository.calTotalRevenue();
	}

	
	

}
