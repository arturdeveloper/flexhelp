package com.jdb.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.jdb.DAOI.MarketplaceServicesDAOI;
import com.jdb.entities.Category;
import com.jdb.entities.Offer;
import com.jdb.entities.Orders;
import com.jdb.entities.Provider;
import com.jdb.entities.SearchFilter;
import com.jdb.entities.User;

public class MarketplaceServices implements MarketplaceServicesDAOI {

	@Override
	public List<Offer> getAllMatchingOffers(SearchFilter filter) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		List<Offer> offers = new ArrayList<>();
		try {

//			Query query = manager.createQuery("SELECT e FROM Offer e WHERE e.location = :pLocation");
//			query.setParameter("pLocation", filter.getLocation());

			Query query = manager.createQuery("SELECT e FROM Offer e");

			offers = query.getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
		return offers;
	}

	@Override
	public List<Category> getCategories() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();
		List<Category> categories = new ArrayList<>();

		try {
			Query query = manager.createQuery("SELECT e FROM Category e");
			categories = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return categories;
	}

	@Override
	public List<Offer> getOffersByProviderId(User provider) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();
		List<Offer> offers = new ArrayList<>();

		try {
			Query query = manager.createQuery("SELECT e FROM Offer e WHERE e.provider.id = :pProvider");
			query.setParameter("pProvider", provider.getId());
			offers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return offers;
	}

	@Override
	public Offer getOfferById(int offerId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		Offer foundOffer = null;

		try {
			manager.getTransaction().begin();
			foundOffer = manager.find(Offer.class, offerId);
			manager.getTransaction().commit();
		} catch (Exception e) {
			foundOffer = null;
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return foundOffer;
	}

	@Override
	public boolean addOfferToOrders(Orders newOrder) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		try {
			manager.getTransaction().begin();
			manager.persist(newOrder);
			manager.getTransaction().commit();
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return result;
	}

	@Override
	public List<Orders> getOrdersByCustomerId(User customer) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();
		List<Orders> orders = new ArrayList<>();
		
		try {
			Query query = manager.createQuery("SELECT e FROM Orders e WHERE e.customer.id = :pCustomer");
			query.setParameter("pCustomer", customer.getId());
			orders = query.getResultList();
			
			orders.stream().forEach(c -> System.out.println("/getOrdersByCustomerId " + c.toString()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return orders;
	}

}
