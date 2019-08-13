/*
 * This is what Provider offers in the marketplace. He can attach criteria, which only the 
 * customers who satisfy this criteria can see the offer.
 * 
 * OfferType:
 * parking/housing rental
 * tool rental
 * help (snow removal, gardening)
 * tutoring
 * 
 * 
 * Criteria:
 * available hours
 * customer ranking
 * house size(gardening case)
 * age (tutoring)
 * 
 * CriteriaDetail is attached to the OfferType.
 * Provider sets the values for these Criteria which are acceptable to him.
 * Provider also sets the price per unit
 * 
 * OfferDetail
 * Describes the offer. Some verbal description and then some details.
 * How many rooms. Square footage. Place for one car (parking).
 * Hourly rate, qualifications.
 * 
 * 
 */

package com.jdb.entities;

public class OfferView {

//	int offerId;

	int categoryId;
	int providerId;

	double price; // per unit
	String location;
	int discountCriteria;

	/*
	 * Provider can set discount/acceptance points based on Customer "reputation"
	 */
	// TODO: can now add this back :)
//	@OneToOne(cascade = CascadeType.PERSIST)
//	CustomerCriteria criteria;

//	 TODO: add this props directly to this class. No need for intermediate class.
//	int availableQuantity;
//  Date availableDate

	public OfferView() {
		super();
	}

	public OfferView(int categoryId, int providerId, double price, String location, int discountCriteria) {
		super();
		this.categoryId = categoryId;
		this.providerId = providerId;
		this.price = price;
		this.location = location;
		this.discountCriteria = discountCriteria;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDiscountCriteria() {
		return discountCriteria;
	}

	public void setDiscountCriteria(int discountCriteria) {
		this.discountCriteria = discountCriteria;
	}

	@Override
	public String toString() {
		return "OfferView [categoryId=" + categoryId + ", providerId=" + providerId
				+ ", price=" + price + ", location=" + location + ", discountCriteria=" + discountCriteria + "]";
	}

}
