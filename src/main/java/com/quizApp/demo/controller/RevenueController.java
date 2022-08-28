package com.quizApp.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Convert;

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

import com.quizApp.demo.model.Revenue;
import com.quizApp.demo.service.RevenueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/revenue")
public class RevenueController {
	
	@Autowired
	private RevenueService revenueService;
	
	@PostMapping("/")
	public Revenue addTest(@RequestBody Revenue revenue){
		
		return this.revenueService.addRevenue(revenue);	
	}
	
	@GetMapping("/{id}")
	public Revenue getRevenueById(@PathVariable("id") long id) {
		return this.revenueService.getRevenue(id);
	}
	
	@GetMapping("/")
	public Set<Revenue> getAllRevenue() {
		return this.revenueService.getAllRevenues();
	}
	
	@DeleteMapping("/{id}")
	public void deleteRevenue(@PathVariable("id")long id) {
		this.revenueService.deleteRevenue(id);
	}
	
	@PutMapping("/{id}")
	public Revenue updateRevenue(@PathVariable("id")long id,@RequestBody Revenue revenue) {
		
		return this.revenueService.updateQuiz(id,revenue);
	}
	
	@GetMapping("/{startDate}/{endDate}")
	public Set<Revenue> getRevenuesByDate(@PathVariable("startDate")String startDate,@PathVariable("endDate")String endDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		String date1=startDate+" 00:00:00";
		String date2=endDate+" 23:59:59";
		LocalDateTime sDate = LocalDateTime.parse(date1,formatter);
		LocalDateTime eDate = LocalDateTime.parse(date2,formatter);

		
		return this.revenueService.getRevenuesByDate(sDate, eDate);
	}
	
	@GetMapping("/totalRevenue")
	public int getTotalRevenue() {
		return this.revenueService.getTotalRevenue();
	}
	
	
}
