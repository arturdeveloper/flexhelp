package com.jdb.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-08-08T05:16:33.011-0400")
@StaticMetamodel(Orders.class)
public class Orders_ {
	public static volatile SingularAttribute<Orders, Integer> orderId;
	public static volatile SingularAttribute<Orders, User> customer;
	public static volatile SingularAttribute<Orders, Offer> offer;
	public static volatile SingularAttribute<Orders, Double> totalPrice;
	public static volatile SingularAttribute<Orders, Date> orderStartDate;
	public static volatile SingularAttribute<Orders, Date> orderEndDate;
	public static volatile SingularAttribute<Orders, Integer> providerRating;
	public static volatile SingularAttribute<Orders, Integer> customerRating;
}
