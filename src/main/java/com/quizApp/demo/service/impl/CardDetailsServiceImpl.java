package com.quizApp.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizApp.demo.model.CardDetails;
import com.quizApp.demo.repo.CardDetailsRepo;
import com.quizApp.demo.repo.QuestionRepository;
import com.quizApp.demo.service.CardDetailsService;

@Service
public class CardDetailsServiceImpl implements CardDetailsService {
	

    @Autowired
    private CardDetailsRepo cardDetailsRepository;

	@Override
	public CardDetails addCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		return this.cardDetailsRepository.save(cardDetails);
	}

	@Override
	public CardDetails updateCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub

		return this.cardDetailsRepository.save(cardDetails);
	}

	@Override
	public Set<CardDetails> getCards() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.cardDetailsRepository.findAll());
	}

	@Override
	public void deleteCardDetail(long id) {
		// TODO Auto-generated method stub
		this.cardDetailsRepository.deleteById(id);
	}

	@Override
	public CardDetails getCardById(Long id) {
		// TODO Auto-generated method stub
		return this.cardDetailsRepository.findById(id).get();
	}

	@Override
	public boolean validateCard(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		//		data=this.userRepository.findByEmail(email);
		CardDetails card;
		card=this.cardDetailsRepository.findBycardNumber(cardDetails.getCardNumber());
		if(card!=null) {
			if(card.equals(cardDetails)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

}
