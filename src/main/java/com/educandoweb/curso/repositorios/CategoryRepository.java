package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entidade.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Long>{

}
