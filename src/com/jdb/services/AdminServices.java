package com.jdb.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jdb.DAOI.AdminDAOI;
import com.jdb.entities.Category;

public class AdminServices implements AdminDAOI {

	@Override
	public boolean addCategory(Category category) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		System.out.println(category.toString());

		try {
			manager.getTransaction().begin();
			manager.persist(category);
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
