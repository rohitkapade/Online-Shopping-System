package com.Shopping.Services;

import java.util.*;

import com.Shopping.Exception.ProductException;
import com.Shopping.Model.Product;
import com.Shopping.Model.SellerProducts;

public interface ProductServices {
	
	public List<SellerProducts> viewAllProducts() throws ProductException;

	public SellerProducts updateProduct(SellerProducts product, Integer sellerID) throws ProductException;
	
	public SellerProducts viewProduct(Integer productId) throws ProductException;
	
	public List<SellerProducts> viewProductByCategory(String category) throws ProductException;
	
	public SellerProducts removeProduct(Integer productId) throws ProductException;

}
