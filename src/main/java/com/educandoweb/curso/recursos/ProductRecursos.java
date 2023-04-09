package com.educandoweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entidade.Product;
import com.educandoweb.curso.servicos.ProductServices;

@RestController
@RequestMapping(value = "/Products")
public class ProductRecursos {
	
	@Autowired
	private ProductServices service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.localizarTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Product> LocalizadorId(@PathVariable Long id){
		Product obj = service.localizarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
