package com.customer.dao;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	List<Customer> findAllCustomer();

	List<Customer> findCustomerSearch(Customer customer);

	List<Customer> findByCustomerID(long customer_id);
}