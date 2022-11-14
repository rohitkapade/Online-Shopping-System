package com.Shopping.Services.Order;

import java.time.LocalDate;
import java.util.List;

import com.Shopping.Exception.CustomerException;
import com.Shopping.Exception.LoginException;
import com.Shopping.Exception.OrderException;
import com.Shopping.Model.Order;
import com.Shopping.Model.OrderDTO;

public interface OrderService {
	
	public Order addOrder(Order order, String key)throws CustomerException,LoginException;
	
	public Order updateOrder(Order updateOrder, String Key)throws OrderException,CustomerException,LoginException;
	
	public Order removeOrder(Integer orderId)throws OrderException,CustomerException;
	
	public OrderDTO viewOrder(Integer orderId) throws OrderException;
	
	public List<Order> viewAllOrders(LocalDate date) throws OrderException;
	
//	public List<Order> viewAllOrdersByLocation(String loc);
	
	public List<Order> viewAllOrdersByUserId(Integer userid)throws CustomerException;
	

}
