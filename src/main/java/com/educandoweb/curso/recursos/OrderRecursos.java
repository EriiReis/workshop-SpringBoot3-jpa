package com.educandoweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entidade.Order;
import com.educandoweb.curso.servicos.OrderServices;

@RestController
@RequestMapping(value = "/Orders")
public class OrderRecursos {
	
	@Autowired
	private OrderServices service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = service.localizarTudo();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")	
	public ResponseEntity<Order> LocalizadorId(@PathVariable Long id){
		Order obj = service.localizarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
