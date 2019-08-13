package com.jdb.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "customer")
public class Customer extends User {

//	int customerRating;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Provider(int providerRating) {
//		super();
//		this.providerRating = providerRating;
//	}

//	public Provider(int id, String uname, String email, String password) {
//		super();
//	}

	public Customer(int id, String uname, String email, String password) {
		super();
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", uname=" + uname + ", email=" + email + ", userPassword=" + password
				+ "]";
	}

}
