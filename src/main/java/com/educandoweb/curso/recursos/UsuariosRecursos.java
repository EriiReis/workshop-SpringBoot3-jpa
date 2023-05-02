package com.educandoweb.curso.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entidade.User;
import com.educandoweb.curso.servicos.UserServices;

@RestController
@RequestMapping(value = "/Users") //Caminho
public class UsuariosRecursos {
	
	@Autowired
	private UserServices service;
	
	//Buscar todos os usuarios do banco - END POINT
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.localizarTudo();
		return ResponseEntity.ok().body(list);
		
	}
	//Busca por ID - END POINT
	@GetMapping(value = "/{id}")	
	public ResponseEntity<User> LocalizadorId(@PathVariable Long id){
		User obj = service.localizarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERINDO O USUARIO NO BANCO DE DADOS - 314
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//CRIANDO UMA VRIVEL PARA GERAR UM ENDERECO URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
