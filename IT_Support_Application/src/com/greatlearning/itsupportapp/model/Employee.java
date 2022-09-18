/**
 * @author hamza
 * This is a Employee class using parameterized constructor of class Employee, to pass firstName, lastName
 */
package com.greatlearning.itsupportapp.model;

public class Employee {

	private String firstName;
	private String lastName;
	
	public Employee (String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//Using getters & setters
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
	

}
