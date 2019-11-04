package com.dell.emc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dell.emc.exception.ResourceNotFoundException;
import com.dell.emc.model.Customer;
import com.dell.emc.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService {
	

	@Autowired
	private CustomerRepository emcRepository;
	
	public List<Customer> findAll() {
		return emcRepository.findAll();
	}
	
	
	public Customer getCustomerByid(Long emcId) throws ResourceNotFoundException {
		return emcRepository
        .findById(emcId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + emcId));
	}
	
	public Customer createCustomer(Customer emc) {
		 return emcRepository.save(emc);
	}
	
	public void deleteCustomer(Customer emc) {
		 emcRepository.delete(emc);
	}

	

}
