package com.telecom.user.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telecom.user.dao.UserOrderDao;
import com.telecom.user.exception.OrderNotFoundException;
import com.telecom.user.exception.OrderValidationException;
import com.telecom.user.exception.UserPermissionException;
import com.telecom.user.model.Order;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.User;
@Component
public class UserOrderValidation  {
	
	@Autowired
    UserOrderDao orderDao;
	

	public String validateUserOrderDetails(String userId, String phonenumber) throws UserPermissionException,OrderNotFoundException {
		
		String validationStatus = "";
		List<Phonenumber> phoneList = new ArrayList<Phonenumber>();
		List<String> numberList = new ArrayList<String>();
		List<String> usernumberList = new ArrayList<String>();
		User userDb = null;
		userDb = orderDao.getUserByUserId(userId);
		phoneList = orderDao.getPhoneDetailsByUserId(userId);
		if(!phoneList.isEmpty())
		{
			phoneList.forEach(phoneNumber->{
				numberList.add(phoneNumber.getIdentifier());
				
				if(phoneNumber.getUserId().equalsIgnoreCase(userId))
				{
					usernumberList.add(phoneNumber.getIdentifier());
				}
			});
			
		}
		
		if(userDb != null)
		{
			if(!userDb.getRole().equalsIgnoreCase("admin") && !usernumberList.contains(phonenumber))
			{
				throw new OrderNotFoundException("User is not associated with the phone number");
			}
			else if(userDb.getRole().equalsIgnoreCase("admin") && !numberList.contains(phonenumber))
			{
				throw new OrderNotFoundException("User details not found in downstream system");
			}
			else {
				validationStatus ="Validated" ;
			}
			
		}
		else
		{
			throw new OrderNotFoundException("User details not found");
		}
		
		return validationStatus ;
	}
   
public String validateUserDetails(String userId) throws OrderNotFoundException {
		
		String validationStatus = "";
		User userDb = null;
		 userDb = orderDao.getUserByUserId(userId);
		
		if(userDb == null)
		{
			
			throw new OrderNotFoundException("User details not found");
		}
		
		return validationStatus ;
	}

public String validateUserOrderDetailsPhone(String userId, String phonenumber,String orderId) throws UserPermissionException,OrderNotFoundException,OrderValidationException {
	
	String validationStatus = "Validated";
	validateUserOrderDetails( userId, phonenumber);
	Order orderdb =null ;
	orderdb = orderDao.getOrderByOrderId(orderId);
	if(orderdb != null)
	{
		if(!(orderdb.getUserId().equalsIgnoreCase(userId) && orderdb.getIdentifier().equalsIgnoreCase(phonenumber)))
		{
			throw new OrderValidationException("INVALID_ARGUMENT", "Order details not matching with user and phonenumber");
		}
			
	}
	else
	{
		throw new OrderNotFoundException("Order details not found");
	}
	
	return validationStatus;
	
}
}