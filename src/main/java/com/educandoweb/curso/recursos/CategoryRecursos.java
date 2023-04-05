package com.educandoweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entidade.Categoria;
import com.educandoweb.curso.servicos.CategoryServices;

@RestController
@RequestMapping(value = "/Categories")
public class CategoryRecursos {
	
	@Autowired
	private CategoryServices service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		
		List<Categoria> list = service.localizarTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Categoria> LocalizadorId(@PathVariable Long id){
		Categoria obj = service.localizarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
