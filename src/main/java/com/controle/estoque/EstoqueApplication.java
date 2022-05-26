package com.controle.estoque;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controle.estoque.rest.domain.model.Product;
import com.controle.estoque.rest.repository.ProductRepository;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product prod = new Product("Galaxy A20s", "Celular", (double) 4500, "Samsung", "1234678");
		Product prod1 = new Product("Motorola", "Notebook", (double) 5999, "Lenovo", "1234000");

		productRepository.saveAll(Arrays.asList(prod, prod1)); //salva no banco
	}

}
