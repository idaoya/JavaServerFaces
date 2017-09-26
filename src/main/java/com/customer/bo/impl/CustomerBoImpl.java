package com.customer.bo.impl;

import java.util.List;
import com.customer.bo.CustomerBo;
import com.customer.dao.CustomerDao;
import com.customer.model.Customer;

public class CustomerBoImpl implements CustomerBo {

	CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}

	public List<Customer> findByCustomerID(long customer_id) {
		return customerDao.findByCustomerID(customer_id);
	}

	public List<Customer> findCustomerSearch(Customer customer) {
		return customerDao.findCustomerSearch(customer);
	}
}