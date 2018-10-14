package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


// https://stackoverflow.com/questions/19154202/data-access-object-dao-in-java
// always applied to DAO implementations
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	// not good design pattern
	//@Transactional
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query and sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName asc", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session and save to database
		
		Session currentSession = sessionFactory.getCurrentSession();
		
//		currentSession.save(theCustomer);	
//		currentSession.update(theCustomer);	
		currentSession.saveOrUpdate(theCustomer);	
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}


}
