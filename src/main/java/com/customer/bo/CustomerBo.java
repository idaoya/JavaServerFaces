package com.customer.bo;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerBo {

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	List<Customer> findAllCustomer();
	
	List<Customer> findCustomerSearch(Customer customer);

	List<Customer> findByCustomerID(long customer_id);
}