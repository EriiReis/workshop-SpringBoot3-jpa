package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entidade.OrderItem;

public interface OrdemItemRepository extends JpaRepository<OrderItem, Long>{

}
