package com.infosys.springboot.restful.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
//@EqualsAndHashCode(exclude = "accounts")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String firstName;

	@NotBlank
	@Size(max = 40)
	private String lastName;


	@NotBlank
	@Size(max = 40)
	@Email
	private String email;
	
	@Size(max = 12)
	private String phone;
	
	
	@Size(max = 255)
	private String address1;
	
	@Size(max = 255)
	private String address2;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Account> accounts = new HashSet<>();

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity=Account.class )
    //private Set<Account> accounts;

	
	  public Set<Account> getAccounts() { return accounts; }
	  
	  public void setAccounts(Set<Account> accounts) { this.accounts = accounts; }
	 
	  
	
	
	/*
	 * public User(String firstName, String lastName, String email, String phone,
	 * String address1, String address2, Account... accounts) {
	 * 
	 * this.firstName = firstName; this.lastName = lastName; this.email = email;
	 * this.phone = phone; this.address1 = address1; this.address2 = address2;
	 * this.accounts = Stream.of(accounts).collect(Collectors.toSet());
	 * //this.accounts.forEach(x -> x.setUserId(id)); }
	 */
	 
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

}
