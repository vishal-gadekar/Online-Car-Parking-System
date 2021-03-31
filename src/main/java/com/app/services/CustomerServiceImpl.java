package com.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exc.ResourceNotFoundException;
import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public Customer authenticateCustomer(String email, String password) {
		Customer c = customerRepo.findByEmailAndPassword(email, password);
		return c;
	}

	@Override
	public Customer registerCustomer(Customer c) {
		customerRepo.save(c);
		return c;
	}

	@Override
	public String deleteCustomerDetails(int customerId) {
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User ID"));
		customerRepo.delete(customer);
		return "User details for ID " + customerId + " deleted...";
	}

	@Override
	public List<Customer> allCustomer() {
		
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerDetails(int customerId) {
		Customer c = customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Customer Id"));
		return c;
	}

}
