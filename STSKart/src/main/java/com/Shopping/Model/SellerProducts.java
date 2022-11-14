package com.Shopping.Model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SellerProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	private String productName;
	
	
	private double price;
	
	private Integer quantity;
	
	private String colour;

	private String dimension;
	private String specification;
	private String manufacutrer;
	
	
	private String category;
	
	@JsonIgnore
	@ManyToOne
	private Seller seller ;
}
