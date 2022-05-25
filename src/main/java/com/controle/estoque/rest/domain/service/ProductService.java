package com.controle.estoque.rest.domain.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.rest.domain.model.Product;
import com.controle.estoque.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	public Product save(Product product) {
		return repository.save(product);
	}
	
	public List<Product> getList(){
		return repository.findAll();
	}
	
	public Product getById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, null));
	}
	
	public void deleteById(Integer id) {
		 repository.deleteById(id);
	}
	
	
}
