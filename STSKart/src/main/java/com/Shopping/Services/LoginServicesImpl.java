package com.Shopping.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.Exception.LoginException;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Customer;
import com.Shopping.Model.Login;
import com.Shopping.Repository.CurrentUserSessionRepo;
import com.Shopping.Repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServicesImpl implements LoginServices{

	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserRepo;
	
	@Override
	public CurrentUserSession login(Login log) throws LoginException{
		Customer currentCustomer= cRepo.findByEmail(log.getEmail());
		
		if(currentCustomer==null) throw new LoginException("Incorrect Email_ID"); 
		
		 Optional<CurrentUserSession> opt= currentUserRepo.findById(currentCustomer.getCustomerId());
		
		 if(opt.isPresent()) {
			throw new LoginException("User Already LOgged In...");
		 }
		 
		 String key=RandomString.make(6);
		 
		 CurrentUserSession cSession=new CurrentUserSession(currentCustomer.getCustomerId(), LocalDateTime.now(), key);
		 return currentUserRepo.save(cSession);
		 
	}

	@Override
	public String Logout(String uuid) throws LoginException{
		
		CurrentUserSession activeUserSession= currentUserRepo.findByUuid(uuid);
		
		if(activeUserSession==null) throw new LoginException("Incorrect uuid or userAlready logged out..");
		
		currentUserRepo.delete(activeUserSession);
		return "Logged Out...";
	}

	
}
