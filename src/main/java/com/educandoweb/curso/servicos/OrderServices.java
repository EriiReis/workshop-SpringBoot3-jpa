package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidade.Order;
import com.educandoweb.curso.repositorios.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository repository;

	public List<Order> localizarTudo(){
		return repository.findAll();
	}
	
	public Order localizarId(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
