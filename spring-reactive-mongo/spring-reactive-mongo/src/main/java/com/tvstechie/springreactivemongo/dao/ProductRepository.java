package com.tvstechie.springreactivemongo.dao;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.tvstechie.springreactivemongo.dto.ProductDTO;
import com.tvstechie.springreactivemongo.entity.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

	Flux<ProductDTO> findByPriceBetween(Range<Integer> range);

}
