package com.quizApp.demo.service;

import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;

import com.quizApp.demo.model.CardDetails;

public interface CardDetailsService {
	
	public CardDetails addCardDetails(CardDetails cardDetails);
	
	public CardDetails updateCardDetails(CardDetails cardDetails);
	
	public Set<CardDetails> getCards();
	
	public void deleteCardDetail(long id);
	
    public CardDetails getCardById(Long id);

	public boolean validateCard(CardDetails cardDetails); 
}
