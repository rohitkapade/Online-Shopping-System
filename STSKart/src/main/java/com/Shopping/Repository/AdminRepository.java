package com.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Seller;


@Repository
public interface AdminRepository extends JpaRepository<Seller	, Integer>{
	
	public Seller findByEmailAndPassword(String email,String password);
	
	public Seller findByEmail(String email);
}
