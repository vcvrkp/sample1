package com.dell.emc.service;

import java.util.List;

import javax.validation.Valid;

import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Customer;

public interface CustomerService {


	Customer getCustomerByid(Long emcId) throws ResourceNotFoundException;

	Customer createCustomer(@Valid Customer emc);

	void deleteCustomer(Customer emc);

	List<Customer> findAll();

}