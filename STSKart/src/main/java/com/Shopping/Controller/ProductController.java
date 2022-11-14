package com.Shopping.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exception.ProductException;
import com.Shopping.Model.Product;
import com.Shopping.Model.SellerProducts;
import com.Shopping.Services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@GetMapping("/product")
    public ResponseEntity<List<SellerProducts>> viewProductsList() throws ProductException{
    	List<SellerProducts> allProducts = productServices.viewAllProducts();
    	return new ResponseEntity<List<SellerProducts>>(allProducts, HttpStatus.OK);
    }
	
//    @PostMapping("/product/add/")
//    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product ) throws ProductException{
//    	Product addedProduct = productServices.addProduct(product);
//    	return new ResponseEntity<Product>(addedProduct, HttpStatus.CREATED);
//    }
	
    @PutMapping("/product/update/")
    public ResponseEntity<SellerProducts> updateProduct(@RequestBody SellerProducts product, @RequestParam Integer sid) throws ProductException{
    	SellerProducts updatedProduct = productServices.updateProduct(product,sid);
    	return new ResponseEntity<SellerProducts>(updatedProduct, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/product/id/{productId}")
    public ResponseEntity<SellerProducts> viewProductByID(@PathVariable("productId") Integer productId) throws ProductException{
    	SellerProducts existingProduct = productServices.viewProduct(productId);
    	return new ResponseEntity<SellerProducts>(existingProduct, HttpStatus.OK);
    }
    
    @GetMapping("/product/category/{category}")
    public ResponseEntity<List<SellerProducts>> viewProductByCategory(@PathVariable("category") String category) throws ProductException{
    	List<SellerProducts> existingProduct = productServices.viewProductByCategory(category);
    	return new ResponseEntity<List<SellerProducts>>(existingProduct, HttpStatus.OK);
    }
    
    @DeleteMapping("/product/delete/{productId}")
    public ResponseEntity<SellerProducts> deleteProductByID(@PathVariable("productId") Integer productId) throws ProductException{
    	SellerProducts deletedProduct = productServices.removeProduct(productId);
    	return new ResponseEntity<SellerProducts>(deletedProduct, HttpStatus.OK);
    }
}
