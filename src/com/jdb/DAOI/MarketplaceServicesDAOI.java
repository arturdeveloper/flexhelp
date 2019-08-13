package com.jdb.DAOI;

import java.util.List;

import com.jdb.entities.Category;
import com.jdb.entities.Offer;
import com.jdb.entities.Orders;
import com.jdb.entities.Provider;
import com.jdb.entities.SearchFilter;
import com.jdb.entities.User;

public interface MarketplaceServicesDAOI {

	List<Category> getCategories();

	List<Offer> getOffersByProviderId(User provider);

	List<Offer> getAllMatchingOffers(SearchFilter filter);

	Offer getOfferById(int offerId);

	boolean addOfferToOrders(Orders newOrder);

	List<Orders> getOrdersByCustomerId(User customer);

}
