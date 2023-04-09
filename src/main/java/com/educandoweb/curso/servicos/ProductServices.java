package com.educandoweb.curso.servicos;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidade.Product;
import com.educandoweb.curso.repositorios.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repository;

	public List<Product> localizarTudo(){
		return repository.findAll();
	}
	
	public Product localizarId(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
