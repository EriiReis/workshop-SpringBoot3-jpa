package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entidade.Categoria;
import com.educandoweb.curso.entidade.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
