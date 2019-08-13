package com.jdb.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jdb.DAOI.EmployeeDAOI;
import com.jdb.entities.Employee;

public class EmployeeServices implements EmployeeDAOI {

	@Override
	public boolean addEmployee(Employee employee) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		boolean result = true;

		try {
			manager.getTransaction().begin();
			manager.persist(employee);
			manager.getTransaction().commit();
		} catch (Exception e) {
			result = false;
//			e.getMessage();
			e.printStackTrace(); // this is more informative
		} finally {
			manager.close();
			factory.close();
		}

		return result;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdb_conn");
		EntityManager manager = factory.createEntityManager();

		List<Employee> employeeList = new ArrayList<>();
		try {
			Query query = manager.createNamedQuery("GetAllEmployees");
			employeeList = query.getResultList();

		} catch (Exception e) {
//			e.getMessage();
			e.printStackTrace(); // this is more informative
		} finally {
			manager.close();
			factory.close();
		}

		return employeeList;
	}

}
