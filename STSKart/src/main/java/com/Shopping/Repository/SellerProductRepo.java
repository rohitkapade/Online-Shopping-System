package com.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Product;
import com.Shopping.Model.SellerProducts;


@Repository
public interface SellerProductRepo extends JpaRepository<SellerProducts, Integer>{
	
	public SellerProducts findByProductId(Product product);

	public List<SellerProducts> findByCategory(String category);

}
