package com.jdb.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "provider")
public class Provider extends User {

//	int providerRating;

	public Provider() {
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

	public Provider(int id, String uname, String email, String password) {
		super();
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", uname=" + uname + ", email=" + email + ", userPassword=" + password
				+ "]";
	}

}
