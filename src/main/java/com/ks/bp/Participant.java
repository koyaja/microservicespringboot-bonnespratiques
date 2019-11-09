package com.ks.bp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participant {
	@Id
	@GeneratedValue
	Long id;
	private String firstName ;
	private String lastName;
	@JsonIgnore
	private Date date;
	private int age;
	// construteur
	public Participant() {
		
	}
	
	public Participant(String firstName, String lastName, Date date, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Participant [firstName=" + firstName + ", lastName=" + lastName + ", date=" + date + ", age=" + age
				+ "]";
	}

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
	 @JsonGetter
	public Date getDate() {
		return date;
	}
	@JsonIgnore
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
