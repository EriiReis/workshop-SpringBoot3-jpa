package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entidade.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
