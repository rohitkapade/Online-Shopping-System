package com.Shopping.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.Exception.ProductException;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Product;
import com.Shopping.Model.SellerProducts;
import com.Shopping.Repository.AdminRepository;
import com.Shopping.Repository.ProductRepo;
import com.Shopping.Repository.SellerProductRepo;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductRepo pRepo;
	
	@Autowired
	private SellerProductRepo sellerProductRepo;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<SellerProducts> viewAllProducts() throws ProductException {
		List<SellerProducts> allProducts = sellerProductRepo.findAll();
		if(allProducts.size() != 0) {			
			return allProducts;
		}
		else throw new ProductException("No Products found");
	}

	@Override
	public SellerProducts updateProduct(SellerProducts product, Integer sid) throws ProductException {
		Optional<SellerProducts> findProduct = sellerProductRepo.findById(product.getProductId());
		if(findProduct.isPresent()) {
			product.setSeller(adminRepository.findById(sid).get());
			SellerProducts updatedProduct = sellerProductRepo.save(product);
			return updatedProduct;
		}
		else throw new ProductException("Invalid Product Details");
	}

	@Override
	public SellerProducts viewProduct(Integer productId) throws ProductException {
		return sellerProductRepo.findById(productId).orElseThrow(()-> new ProductException("No Product found with this ID: "+productId));
	}

	@Override
	public List<SellerProducts> viewProductByCategory(String category) throws ProductException {
		List<SellerProducts> products = sellerProductRepo.findByCategory(category);
		if(products.size() != 0) {
			return products;
		}
		else throw new ProductException("No Products found in this Category: "+category);
	}

	@Override
	public SellerProducts removeProduct(Integer productId) throws ProductException {
		Optional<SellerProducts> findOptional = sellerProductRepo.findById(productId);
		if(findOptional.isPresent()) {
			SellerProducts sProducts = sellerProductRepo.getById(productId);
			sellerProductRepo.delete(sProducts);
			return sProducts;
		}
		else {
			throw new ProductException("No Products found with ID: "+productId);
		}
	}

}
