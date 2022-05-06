package com.tvstechie.springreactivemongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvstechie.springreactivemongo.dto.ProductDTO;
import com.tvstechie.springreactivemongo.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/greetings")
	public String greetings(){
		return "Hello World";
		
	}
	
	@GetMapping
	public Flux<ProductDTO> getProducts(){
		return productService.getProducts();
		
	}
	
	@GetMapping(path = "/{id}")
	public Mono<ProductDTO> getProducts(@PathVariable(name = "id") String id){
		return productService.getProduct(id);
		
	}
	
	@GetMapping(path="/price-range")
	public Flux<ProductDTO> getProductInRange(@RequestParam("min") int min, @RequestParam("max") int max){
		return productService.getProductInRange(min, max);
		
	}
	
	@PostMapping
	public Mono<ProductDTO> insertProduct(@RequestBody Mono<ProductDTO> productDTO){
		return productService.insertProduct(productDTO);
		
	}
	
	@PutMapping(path = "/update/{id}")
	public Mono<ProductDTO> insertProduct(@RequestBody Mono<ProductDTO> productDTO, @PathVariable("id") String id){
		return productService.updateProduct(productDTO, id);
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public Mono<Void> deleteProduct(@PathVariable("id") String id){
		return productService.deleteProduct(id);
		
	}
	
	
	
	

}
