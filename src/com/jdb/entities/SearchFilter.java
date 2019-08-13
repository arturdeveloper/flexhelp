package com.jdb.entities;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

public class SearchFilter {

	String location;

//	@Min(0)
//	int fromPrice;
	String fromPrice;

//	@Min(0)
//	double budgetEnd;
	String toPrice; // to set budget option

	int provLevel; // use composite type here??

//	String catalogId;

	// TODO: adds complexity
//	Date availability;

	public SearchFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchFilter(String location, String fromPrice, String toPrice, int provLevel) {
		super();
		this.location = location;
		this.fromPrice = fromPrice;
		this.toPrice = toPrice;
		this.provLevel = provLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(String fromPrice) {
		this.fromPrice = fromPrice;
	}

	public String getToPrice() {
		return toPrice;
	}

	public void setToPrice(String toPrice) {
		this.toPrice = toPrice;
	}

	public int getProvLevel() {
		return provLevel;
	}

	public void setProvLevel(int provLevel) {
		this.provLevel = provLevel;
	}

	@Override
	public String toString() {
		return "SearchFilter [location=" + location + ", fromPrice=" + fromPrice + ", toPrice=" + toPrice + "]";
	}

}
