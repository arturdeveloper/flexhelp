package com.jdb.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.jdb.DAOI.CustomerServicesDAOI;
import com.jdb.entities.Customer;

public class CustomerServices implements CustomerServicesDAOI {

	@Override
	public boolean addCustomer(Customer user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		Customer customer = new Customer();
		customer.setUname(user.getUname());
		customer.setEmail(user.getEmail());
		customer.setPassword(user.getPassword());

		System.out.println(customer.toString());

		try {
			manager.getTransaction().begin();
//			manager.persist((Customer) customer);
			manager.persist(user);
			manager.getTransaction().commit();
		} catch (PersistenceException e) {
			result = false;
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}

		return result;
	}

}
