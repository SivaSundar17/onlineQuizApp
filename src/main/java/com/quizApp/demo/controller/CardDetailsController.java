package com.quizApp.demo.controller;

import java.io.Console;

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

import com.quizApp.demo.model.CardDetails;
import com.quizApp.demo.service.CardDetailsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/card")
public class CardDetailsController {

	@Autowired
	private CardDetailsService cardDetailsService;

	@PostMapping("/addCard")
	public ResponseEntity<String> addCard(@RequestBody CardDetails cardDetails){
		this.cardDetailsService.addCardDetails(cardDetails);
		return new ResponseEntity<>("Card details added Successfully", HttpStatus.OK);
		
	}
	@GetMapping("/getCards")
	public ResponseEntity<?> getCards() {
      return ResponseEntity.ok(this.cardDetailsService.getCards());
  }
	
  @GetMapping("/{id}")
  public CardDetails getcardById(@PathVariable("id") Long id) {
      return this.cardDetailsService.getCardById(id);
  }
  
  @PutMapping("/updateCard/{id}")
  public CardDetails  update(@PathVariable Long id,@RequestBody CardDetails cardDetails) {
	  return this.cardDetailsService.updateCardDetails(cardDetails);
	  }
  
	@DeleteMapping("/deleteCard/{id}")
	public void deleteCard(@PathVariable("id") Long id) {
		this.cardDetailsService.deleteCardDetail(id);
	}
	
	@PostMapping("/validate")
	public boolean validate(@RequestBody CardDetails cardDetails) {
		return this.cardDetailsService.validateCard(cardDetails);
	}
}
