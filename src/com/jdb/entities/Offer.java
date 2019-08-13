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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int offerId;

	@OneToOne(cascade = CascadeType.DETACH)
	Category category;

	@ManyToOne
	Provider provider;

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

	public Offer() {
		super();
	}

	public Offer(Category category, Provider provider, double price, String location, int discountCriteria) {
		super();
		this.category = category;
		this.provider = provider;
		this.price = price;
		this.location = location;
		this.discountCriteria = discountCriteria;
	}

	public int getOfferId() {
		return offerId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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
		return "Offer [offerId=" + getOfferId() + ", category=" + category + ", provider=" + provider + ", price=" + price
				+ ", location=" + location + ", discountCriteria=" + discountCriteria + "]";
	}

}
