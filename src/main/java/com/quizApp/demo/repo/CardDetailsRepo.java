package com.quizApp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.CardDetails;
import com.quizApp.demo.model.User;

@Repository
public interface CardDetailsRepo extends JpaRepository<CardDetails, Long> {

	CardDetails findBycardNumber(String string);

    
//    Route findByOriginAndDestination(long originId, long destinationId);


}
