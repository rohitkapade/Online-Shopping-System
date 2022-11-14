package com.Shopping.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exception.SellerException;
import com.Shopping.Model.Seller;
import com.Shopping.Model.SellerProducts;
import com.Shopping.Services.AdminService;



@RestController
@RequestMapping(value = "/admin")
public class SellerController {

	@Autowired
	private AdminService ad;
//	@Autowired
//	private PrService ps;
	
	
	@PostMapping("/CreateAdmin")
	public ResponseEntity<Seller> createAccount(@Valid @RequestBody Seller admin) throws SellerException{
	Seller adm = ad.insertAdmin(admin);
		
		return new ResponseEntity<Seller>(adm,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<Seller> deleteAccount(@RequestParam String email,@RequestParam String password,@RequestParam(required = false) String Uuid) throws SellerException{
		Seller adm = ad.deleteAdmin(email, password, Uuid);
		
			
			return new ResponseEntity<Seller>(adm,HttpStatus.OK);
		}
	@PostMapping("/addProductforSell")
	public ResponseEntity<SellerProducts> addProd(@RequestBody SellerProducts product ,@RequestParam Integer adminId) throws SellerException{
		SellerProducts pro = ad.addProduct(product,adminId);
		
		return new ResponseEntity<SellerProducts>(pro,HttpStatus.OK); 
	}
}
