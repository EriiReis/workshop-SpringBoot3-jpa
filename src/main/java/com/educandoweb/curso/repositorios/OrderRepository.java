package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entidade.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
