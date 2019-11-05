package com.infosys.springboot.restful.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "account")
@Data
@Entity
public class Account{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 16)
	private String accountNumber;
	

	private Long balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	//@Column(name = "user_id")
	private User user;	
	
//	@ManyToOne
//   @JoinColumn
//  private User user;
	
	


	/*
	 * public Account(String accountNumber, Long balance) {
	 * 
	 * this.accountNumber = accountNumber; this.balance = balance; //this.user =
	 * user; }
	 */	 














	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
