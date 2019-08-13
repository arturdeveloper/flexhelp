package com.jdb.DAOI;

import java.util.List;

import javax.validation.Valid;

import com.jdb.entities.Customer;
import com.jdb.entities.Offer;
import com.jdb.entities.SearchFilter;
import com.jdb.entities.User;

public interface CustomerServicesDAOI {

//	boolean addCustomer(@Valid User customer);

	boolean addCustomer(Customer user);

}
