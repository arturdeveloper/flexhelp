package com.jdb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table
@Entity
@NamedQuery(query = "select e from Employee e", name = "GetAllEmployees")
public class Employee {

	@Id
	int id;


	@Basic
	@Column
	String firstName;

	@Basic
	@Column
	String lastName;

	@Basic
	@Column
	String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
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
		return "Employee [id=" + id + ", email=" + email + ", firstName=" + firstName + "]";
	}

}
