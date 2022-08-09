package com.zee.zee5app.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@NoArgsConstructor
public class User implements Comparable<User>{

//	static {
//		System.out.println("static block");
//	}
//	{
//		System.out.println("intialization block");
//	}
//	public User() {
//		// TODO Auto-generated constructor stub"
//		System.out.println("constructor block");
//	}
	@Setter(value = AccessLevel.NONE)
	private String userId;
	
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

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	private String firstName;
//	userId,firstName,lastName,email,doj,dob : instance references
//	active : instance variable
	private String lastName;
	private String email;
	private LocalDate doj;
	private LocalDate dob;
	private boolean active;
	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.userId.compareTo(o.userId);
	}

	public User(String firstName, String lastName, String email, LocalDate doj, LocalDate dob, boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.doj = doj;
		this.dob = dob;
		this.active = active;
	}
}


