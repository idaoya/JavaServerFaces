package com.customer.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import com.customer.dao.CustomerDao;
import com.customer.model.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public void addCustomer(Customer customer) {
		customer.setCreatedDate(new Date());
		getHibernateTemplate().save(customer);
	}

	public void deleteCustomer(Customer customer) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String customerId = params.get("customerId");

		getHibernateTemplate().bulkUpdate("delete from Customer where customer_id = " + customerId);
	}

	@SuppressWarnings("unchecked")
	public void updateCustomer(Customer customer) {

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String customerId = params.get("customerId");
		String name = params.get("name");
		String address = params.get("address");

		List<Customer> results = (List<Customer>) getHibernateTemplate().find("FROM Customer where customer_id = ?",
				new Object[] { new Long(customerId) });

		Customer userToBeUpdate = results.get(0);
		userToBeUpdate.setName(name);
		userToBeUpdate.setAddress(address);
		getHibernateTemplate().saveOrUpdate(userToBeUpdate);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		return getHibernateTemplate().find("from Customer");
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findByCustomerID(long customer_id) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String customerId = params.get("customerId");

		return getHibernateTemplate().find("from Customer where customer_id = " + customerId);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findCustomerSearch(Customer customer) {
		return getHibernateTemplate().find("from Customer where upper(name) =  upper('" + customer.getName() + "')");
	}
}