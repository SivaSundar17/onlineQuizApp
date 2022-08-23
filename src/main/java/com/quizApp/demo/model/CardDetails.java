package com.quizApp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CardDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String Name;
	
	private String type;
	private String cardNumber;
	private String expiry;
	private int cvv;
	
	public CardDetails(long id, String name, String type, String cardNumber, String expiry, int cvv) {
		this.id = id;
		Name = name;
		this.type = type;
		this.cardNumber = cardNumber;
		this.expiry = expiry;
		this.cvv = cvv;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public CardDetails() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		CardDetails card = (CardDetails) obj;
		// TODO Auto-generated method stub
		if(card.cardNumber.equals(this.cardNumber) && card.Name.equals(this.Name) && card.cvv==this.cvv && card.type.equals(this.type) && card.expiry.equals(this.expiry) && card.cardNumber.equals(this.cardNumber))
		{
		return true;
		}
		return false;
	}
	
	
	
}
