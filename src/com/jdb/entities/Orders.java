package com.jdb.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;

	@ManyToOne
//	Customer customer;
	User customer;

	@OneToOne
	Offer offer;

//	Date dateOrdered;

	// TODO: the total is calculated. Don't include this in constructor
	double totalPrice;
	
	// TODO: create two Date points. Don't include this in constructor
	Date orderStartDate;
	Date orderEndDate;
	
	// TODO: create two ratings fields. Don't include this in constructor
	int providerRating;
	int customerRating;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, Customer customer, Offer offer, double totalPrice, Date orderStartDate, Date orderEndDate) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.offer = offer;
		this.totalPrice = totalPrice;
		this.orderStartDate = orderStartDate;
		this.orderEndDate = orderEndDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderStartDate() {
		return orderStartDate;
	}

	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

	public Date getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(Date orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public int getProviderRating() {
		return providerRating;
	}

	public void setProviderRating(int providerRating) {
		this.providerRating = providerRating;
	}

	public int getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(int customerRating) {
		this.customerRating = customerRating;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer + ", offer=" + offer + ", orderStartDate="
				+ orderStartDate + "]";
	}
	
	

	

}