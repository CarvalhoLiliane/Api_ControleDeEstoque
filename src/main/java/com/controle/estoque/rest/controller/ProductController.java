package com.controle.estoque.rest.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.rest.domain.dto.ProductDto;
import com.controle.estoque.rest.domain.model.Product;
import com.controle.estoque.rest.domain.service.ProductService;

@RestController
@RequestMapping(value="/produtos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	private ModelMapper mapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto createProduct(@RequestBody ProductDto productDto) {
		mapper = new ModelMapper();
		Product product = mapper.map(productDto, Product.class);
//		Product productModel = new Product();
//		productModel.setNome(product.getNome());
//		productModel.setDescricao(product.getDescricao());
//		productModel.setNomeFabricante(product.getNomeFabricante());
//		productModel.setPreco(product.getPreco());
//		productModel.setCodigoBarras(product.getCodigoBarras());
		
		Product savedProduct = service.save(product);
		return mapper.map(savedProduct, ProductDto.class);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getList() {
		return service.getList();
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProduct(@PathVariable Integer id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
		mapper = new ModelMapper();
		Product product = mapper.map(productDto, Product.class);
		product.setId(id);
		service.save(product);
	}
	

}
