package com.Shopping.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
	
	private Integer orderId;
	private LocalDate orderDate;
	private String orderStatus;
	
	private Integer CustomerId;
	private Address address;
	
	List<Product> productsInTheOrder = new ArrayList<>();
	
	

}
