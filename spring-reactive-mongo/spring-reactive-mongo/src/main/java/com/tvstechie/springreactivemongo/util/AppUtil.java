package com.tvstechie.springreactivemongo.util;

import org.springframework.beans.BeanUtils;

import com.tvstechie.springreactivemongo.dto.ProductDTO;
import com.tvstechie.springreactivemongo.entity.Product;

public class AppUtil {
	
	public static Product dtoToEntity(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		return product;
		
	}
	
public static ProductDTO entityToDTO(Product product) {
	
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(product, productDTO);
		return productDTO;
		
	}

}
