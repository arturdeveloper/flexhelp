package com.jdb.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jdb.DAOI.ProviderDAOI;
import com.jdb.entities.Category;
import com.jdb.entities.LoginView;
import com.jdb.entities.Offer;
import com.jdb.entities.OfferView;
import com.jdb.entities.Provider;
import com.jdb.entities.User;

public class ProviderServices implements ProviderDAOI {

	@Override
	public boolean addProvider(User provider) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		System.out.println(provider.toString());

		try {
			manager.getTransaction().begin();
			manager.persist(provider);
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

	// TODO: change to addOffer
	@Override
	public boolean addService(OfferView offerView) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		System.out.println(offerView.toString());

		Offer offer = new Offer();
//		offer.setOfferId(offerView.getOfferId()); // id is auto-generated now
		offer.setPrice(offerView.getPrice());
		offer.setLocation(offerView.getLocation());
		offer.setDiscountCriteria(offerView.getDiscountCriteria());

		try {
			manager.getTransaction().begin();
			Provider foundProvider = manager.find(Provider.class, offerView.getProviderId());
			offer.setProvider(foundProvider);
			Category foundCategory = manager.find(Category.class, offerView.getCategoryId());
			offer.setCategory(foundCategory);

			System.out.println(offer.toString());
			manager.persist(offer);
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
	public User validateUser(LoginView login) {
//	public Provider validateUser(LoginView login) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		User user = new User();
//		Provider user = new Provider();

		System.out.println("Service " + login.toString());

		try {
			Query query = manager.createQuery("SELECT e FROM User e WHERE e.uname = :pUserName");
			query.setParameter("pUserName", login.getUname());
			user = (User) query.getSingleResult();
//			user = (Provider) query.getSingleResult();

		} catch (Exception e) {
			user = null;
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		if (user != null && user.getPassword().equalsIgnoreCase(login.getPassword())) {
			return user;
		} else {
			return null;
		}

	}

	@Override
	public boolean updateOffer(OfferView offerView, int offerId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		try {
			manager.getTransaction().begin();

			Offer offer = manager.find(Offer.class, offerId);

			// need to match data type fields
			Provider foundProvider = manager.find(Provider.class, offerView.getProviderId());
			offer.setProvider(foundProvider);

			// update category if changed
			Category foundCategory = manager.find(Category.class, offerView.getCategoryId());
			offer.setCategory(foundCategory);

			// set simple types directly from view
			offer.setPrice(offerView.getPrice());
			offer.setLocation(offerView.getLocation());
			offer.setDiscountCriteria(offerView.getDiscountCriteria());

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
	public boolean deleteOffer(User user, int offerId) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		try {
			manager.getTransaction().begin();

			Offer offer = manager.find(Offer.class, offerId);

			// confirm ownership before deleting
			if (offer.getProvider().getId() == user.getId()) {
				manager.remove(offer);
			} else {
				throw new Exception("Don't have permission to delete this item");
			}

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
}
