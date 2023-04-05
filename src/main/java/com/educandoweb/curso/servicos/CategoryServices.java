package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidade.Categoria;
import com.educandoweb.curso.repositorios.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository repository;

	public List<Categoria> localizarTudo(){
		return repository.findAll();
	}
	
	public Categoria localizarId(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}
}
