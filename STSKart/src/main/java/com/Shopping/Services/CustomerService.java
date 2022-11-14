package com.Shopping.Services;

import org.springframework.stereotype.Service;

import com.Shopping.Exception.CustomerException;
import com.Shopping.Exception.LoginException;
import com.Shopping.Model.Address;
import com.Shopping.Model.Customer;


@Service
public interface CustomerService {
	
	public Customer createAccount(Customer cum) throws CustomerException;
	
	public Address setTheAddress(Address add,Integer id,String key) throws CustomerException,LoginException;
	
	
	public Customer updatecustomer(Customer customer,String key)throws LoginException,CustomerException;
	
}
