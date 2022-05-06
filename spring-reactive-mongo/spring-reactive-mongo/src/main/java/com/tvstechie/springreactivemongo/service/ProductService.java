package com.tvstechie.springreactivemongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.tvstechie.springreactivemongo.dao.ProductRepository;
import com.tvstechie.springreactivemongo.dto.ProductDTO;
import com.tvstechie.springreactivemongo.util.AppUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Flux<ProductDTO> getProducts() {

		return productRepository.findAll().map(AppUtil::entityToDTO);
	}

	public Mono<ProductDTO> getProduct(String id) {

		return productRepository.findById(id).map(AppUtil::entityToDTO);
	}

	public Flux<ProductDTO> getProductInRange(int min, int max) {

		return productRepository.findByPriceBetween(Range.closed(min, max));
	}

	public Mono<ProductDTO> insertProduct(Mono<ProductDTO> productDTO) {

		return productDTO.map(AppUtil::dtoToEntity).flatMap(productRepository::insert).map(AppUtil::entityToDTO);

	}

	public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTO, String id) {

		return productRepository.findById(id)
				.flatMap(p -> productDTO.map(AppUtil::dtoToEntity).doOnNext(e -> e.setId(id)))
				.flatMap(productRepository::save).map(AppUtil::entityToDTO);

	}

	public Mono<Void> deleteProduct(String id) {

		return productRepository.deleteById(id);

	}

}
