package com;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import com.customer.bo.CustomerBo;
import com.customer.model.Customer;

public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	CustomerBo customerBo;
	public String name;
	public String gender;
	public String address;
	public String country;
	public String[] receive;
	public long customerId;
	Customer cust = new Customer();

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getReceive() {
		return receive;
	}

	public void setReceive(String[] receive) {
		this.receive = receive;
	}

	public String getReceiveInString() {
		return Arrays.toString(receive);
	}

	public void setCustomerBo(CustomerBo customerBo) {
		this.customerBo = customerBo;
	}

	public List<Customer> getCustomerList() {
		return customerBo.findAllCustomer();
	}

	public List<Customer> getCustomerByID() {
		return customerBo.findByCustomerID(customerId);
	}

	public List<Customer> getCustomerSearch() {
		return customerBo.findCustomerSearch(cust);
	}

	public String searchCustomer() {
		cust.setName(getName());
		cust.setGender(getGender());
		cust.setAddress(getAddress());
		cust.setCountry(getCountry());
		cust.setReceive(getReceiveInString());

		customerBo.findCustomerSearch(cust);

		clearForm();

		return "";
	}

	public String addCustomer() {

		Customer cust = new Customer();
		cust.setName(getName());
		cust.setGender(getGender());
		cust.setAddress(getAddress());
		cust.setCountry(getCountry());
		cust.setReceive(getReceiveInString());

		customerBo.addCustomer(cust);

		clearForm();

		return "";
	}

	public String deleteCustomer() {

		Customer cust = new Customer();
		cust.setName(getName());
		cust.setAddress(getAddress());

		customerBo.deleteCustomer(cust);

		clearForm();

		return "";
	}

	public String updateCustomer() {

		Customer cust = new Customer();
		cust.setCustomerId(getCustomerId());
		cust.setName(getName());
		cust.setAddress(getAddress());

		customerBo.updateCustomer(cust);

		clearForm();

		return "";
	}

	private void clearForm() {
		setName("");
		setAddress("");
	}
}
