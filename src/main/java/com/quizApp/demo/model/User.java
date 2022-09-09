package com.quizApp.demo.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String mobileNo;
    private boolean enabled=true;
    
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles=new HashSet<>(); 
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private Set<QuizPaymentStatus> quizPaymentStatus=new HashSet<>(); 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TestHistory> testhistorys = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private Set<Revenue> revenue=new HashSet<>(); 
    
//    
//   
    public Set<QuizPaymentStatus> getQuizPaymentStatus() {
		return quizPaymentStatus;
	}

	public void setQuizPaymentStatus(Set<QuizPaymentStatus> quizPaymentStatus) {
		this.quizPaymentStatus = quizPaymentStatus;
	}

	public Set<Revenue> getRevenue() {
		return revenue;
	}

	public void setRevenue(Set<Revenue> revenue) {
		this.revenue = revenue;
	}

	public User() {
    
    }

    public User(Long id, String username, String password, String email, boolean enabled) {
          this.id = id;
          this.username = username;
          this.password = password;
          this.email = email;
          this.enabled = enabled;
    }
    public Long getId() {
          return id;
    }
      
    public void setId(Long id) {
          this.id = id;
    }

    public String getUsername() {
          return username;
    }

    public void setUsername(String username) {
          this.username = username;
    }

    public String getPassword() {
          return password;
    }

    public void setPassword(String password) {
          this.password = password;
    }

    public String getEmail() {
          return email;
    }

    public void setEmail(String email) {
          this.email = email;
    }

    public boolean isEnabled() {
          return enabled;
    }

    public void setEnabled(boolean enabled) {
          this.enabled = enabled;
    }
    

    public String getMobileNo() {
          return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
          this.mobileNo = mobileNo;
    }    
    
    public Set<UserRole> getUserRoles() {
        return userRoles;
  }
    

  public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
  }

}
