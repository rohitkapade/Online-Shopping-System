package com.Shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exception.CustomerException;
import com.Shopping.Exception.LoginException;
import com.Shopping.Model.Cart;
import com.Shopping.Model.Product;
import com.Shopping.Repository.CartRepo;
import com.Shopping.Services.CartService;


@RestController
@RequestMapping(value = "/cart")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	
	@PutMapping("/addProductToCart")
	public ResponseEntity<String> AddProductToCart(@RequestParam Integer pid,@RequestParam Integer custid,@RequestParam String key) throws CustomerException, LoginException{
		
		String s= cartservice.addProductToCart(pid, custid, key);
		
		return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/removeProduct")
	public ResponseEntity<Product> removeProductFromCart(@RequestParam Integer pid,@RequestParam String key,@RequestParam Integer cid) throws Exception{
		
		Product c= cartservice.removeproductFromCart(pid, key, cid);
		
		return new ResponseEntity<Product>(c,HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateQuantity")
	public ResponseEntity<Product> UpdateProductQuantity(@RequestParam Integer cid,@RequestParam Integer pid,@RequestParam Integer quantity,@RequestParam String key) throws Exception{
		
		Product c= cartservice.updateProductQuantity(cid, pid, quantity, key);
		
		return new ResponseEntity<Product>(c,HttpStatus.ACCEPTED);
	}
	
}
