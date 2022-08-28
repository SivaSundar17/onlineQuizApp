package com.quizApp.demo.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.Quiz;
import com.quizApp.demo.model.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue,Long> {

	@Query(value="select * from revenue r where r.date between :startDate and :endDate",nativeQuery = true)
	Set<Revenue> findByDate(@Param("startDate") LocalDateTime startDate,@Param("endDate")LocalDateTime endDate);
	
	@Query(value="select sum(amount) from revenue", nativeQuery=true)
	int calTotalRevenue();

}


