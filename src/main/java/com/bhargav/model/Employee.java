package com.bhargav.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "employee")
public class Employee implements Serializable{
 
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String idEmployee;
 
	private String email;
 
	private String firstName;
 
	private String lastName;
 
	public Employee() {
	}
 
	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getEmail() {
		return this.email;
	}
 
	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}