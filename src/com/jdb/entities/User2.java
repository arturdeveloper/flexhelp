package com.jdb.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
public class User2 {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(uname="ID")
	int id;
	String uname;
	String email;
	String password;

	// TODO: make simple data type. No need to connect to separate table
	// TODO: add this feature later when have time
//	@ManyToMany
//	List<CustomerCriteria> ranking;

//	@OneToMany
//	List<Order> listOfOrders;

	public User2() {
		super();
	}

	public User2(int id, String uname, String email, String password) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
