package com.jfdeveloper.financial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
  public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;

	public Person(){}

	public Person(String firstName, String lastName){
	  this.firstName=firstName;
	  this.lastName=lastName;
	}

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getLastName() {
	  return lastName;
	}

	public void setLastName(String lastName) {
	  this.lastName = lastName;
	}

	public String getFirstName() {
	  return firstName;
	}

	public void setFirstName(String firstName) {
	  this.firstName = firstName;
	}

	@Override
	public String toString() {
	  return "Person{" +
			  "lastName='" + lastName + '\'' +
			  ", firstName='" + firstName + '\'' +
			  '}';
	}
  }
