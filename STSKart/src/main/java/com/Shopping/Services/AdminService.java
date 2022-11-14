package com.Shopping.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Shopping.Exception.SellerException;
import com.Shopping.Model.Seller;
import com.Shopping.Model.SellerProducts;



@Service
public interface AdminService {

	public Seller insertAdmin(Seller admin) throws SellerException ;
	public Seller deleteAdmin(String email , String password,String key) throws SellerException ;
	
	public SellerProducts addProduct(SellerProducts product,Integer id) throws SellerException;
}
