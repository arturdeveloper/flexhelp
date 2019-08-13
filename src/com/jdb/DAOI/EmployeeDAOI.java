package com.jdb.DAOI;

import java.util.List;

import com.jdb.entities.Employee;

public interface EmployeeDAOI {

	boolean addEmployee(Employee employee);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();
}
