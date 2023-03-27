package com.educandoweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entidade.User;
import com.educandoweb.curso.servicos.UserServices;

@RestController
@RequestMapping(value = "/Users")
public class UsuariosRecursos {
	
	@Autowired
	private UserServices service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.localizarTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<User> LocalizadorId(@PathVariable Long id){
		User obj = service.localizarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
