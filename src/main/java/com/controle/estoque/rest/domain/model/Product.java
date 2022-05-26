package com.controle.estoque.rest.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private String nomeFabricante;
	private String codigoBarras;
	
	
//	public Product() {
//	}
	
	public Product(String nome, String descricao, Double preco, String nomeFabricante, String codigoBarras) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.nomeFabricante = nomeFabricante;
		this.codigoBarras = codigoBarras;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
