package com.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Cart;
import com.Shopping.Model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	public Product findByProductId(Integer i);
	
	public List<Product> findByCategory(String category);
}
