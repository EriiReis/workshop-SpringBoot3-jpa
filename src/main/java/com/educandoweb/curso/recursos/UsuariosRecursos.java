package com.educandoweb.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entidade.User;

@RestController
@RequestMapping(value = "/Users")
public class UsuariosRecursos {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1, "Picollo", "namekuzei@gmail.com", "015798892771", "115154878784");
		return ResponseEntity.ok().body(u);
		
		
	}
	
	
}
