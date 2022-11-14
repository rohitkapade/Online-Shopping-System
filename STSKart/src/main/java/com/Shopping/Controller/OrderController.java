package com.Shopping.Controller;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exception.CustomerException;
import com.Shopping.Exception.LoginException;
import com.Shopping.Exception.OrderException;
import com.Shopping.Model.Order;
import com.Shopping.Model.OrderDTO;
import com.Shopping.Services.Order.OrderService;



@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	OrderService order_service;
	
	@PostMapping()
	public ResponseEntity<Order> addOrderHandler(@RequestBody Order order, String key)throws CustomerException,LoginException{
		
		Order requestedOrder = order_service.addOrder(order, key);
		
		return new ResponseEntity<>(requestedOrder,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> updateOrderHandler(@RequestBody Order order, String key)throws OrderException,CustomerException,LoginException{
		
		return new ResponseEntity<>(order_service.updateOrder(order,key),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeOrderHandler(@PathVariable("id") Integer orderId)throws OrderException, CustomerException{
		
		Order order = order_service.removeOrder(orderId);
		
		return new ResponseEntity<>("Order Removed",HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<OrderDTO> viewOrderHandler(@PathVariable("id") Integer orderId)throws OrderException{
		
		OrderDTO orderDto = order_service.viewOrder(orderId);
		
		return new ResponseEntity<>(orderDto,HttpStatus.OK);
		
	}
	
	@GetMapping("viewByDate")
	public ResponseEntity<List<Order>> viewAllOrderByDate(@RequestBody LocalDate date)throws OrderException{
		
		List<Order> orderByDate = order_service.viewAllOrders(date);
		
		return new ResponseEntity<>(orderByDate,HttpStatus.ACCEPTED);
		
	}
	

	
	
	@GetMapping("/viewByUserId/{id}")
	public ResponseEntity<List<Order>> viewAllOrderByUserId(@PathVariable("id") Integer userId) throws CustomerException{
		
		List<Order> orderByUserId = order_service.viewAllOrdersByUserId(userId);
		
		return new ResponseEntity<>(orderByUserId,HttpStatus.ACCEPTED);
	}
	
	

}
