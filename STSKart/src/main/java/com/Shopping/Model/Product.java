package com.Shopping.Model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId ;
	
//	@NotNull(message = "Product name cannot be empty")
//	@Size(min = 3, max = 20, message = "Product Name should contain min 3 character." )
	private String productName;
	
//	@Min(value = 1, message = "Product price should not be 0")
	private Double price;
	
//	@NotNull(message = "Product Color cannot be empty")
//	@Size(min = 3, max = 20, message = "Product Color should contain min 3 character." )
	private String color;
	
	
	private String dimension;
	
	
	private String specification;
	
	
	private String manufacturer;
	
//	@NotNull(message = "Product Quantity cannot be empty")
//	@Min(value = 1, message = "Product Quantity should not be 0")
	private Integer quantity;
	
	
	private String category;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Order order;
	
	

}
