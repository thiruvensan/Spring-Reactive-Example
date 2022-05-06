package com.tvstechie.springreactivemongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private String id;
	private String name;
	private int quantity;
	private int price;

}
