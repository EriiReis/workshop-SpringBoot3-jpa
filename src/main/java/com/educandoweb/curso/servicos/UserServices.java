package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidade.User;
import com.educandoweb.curso.repositorios.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;

	public List<User> localizarTudo(){
		return repository.findAll();
	}
	
	public User localizarId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//Operaco para salvar usuario no banco de dados -  vi retornar o usuario salvo - 314
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
