package com.jdb.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-08-09T20:27:38.115-0400")
@StaticMetamodel(Offer.class)
public class Offer_ {
	public static volatile SingularAttribute<Offer, Integer> offerId;
	public static volatile SingularAttribute<Offer, Category> category;
	public static volatile SingularAttribute<Offer, Provider> provider;
	public static volatile SingularAttribute<Offer, Double> price;
	public static volatile SingularAttribute<Offer, String> location;
	public static volatile SingularAttribute<Offer, Integer> discountCriteria;
}
