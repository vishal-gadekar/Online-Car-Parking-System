package com.app.services;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerService {

	Customer authenticateCustomer(String email, String password);

	Customer registerCustomer(Customer c);

	String deleteCustomerDetails(int customerId);

	List<Customer> allCustomer();

	Customer getCustomerDetails(int customerId);

}
