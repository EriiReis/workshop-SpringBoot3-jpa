package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entidade.Categoria;
import com.educandoweb.curso.entidade.Order;
import com.educandoweb.curso.entidade.OrderItem;
import com.educandoweb.curso.entidade.Payment;
import com.educandoweb.curso.entidade.Product;
import com.educandoweb.curso.entidade.User;
import com.educandoweb.curso.entidade.enums.OrderStatus;
import com.educandoweb.curso.repositorios.CategoryRepository;
import com.educandoweb.curso.repositorios.OrdemItemRepository;
import com.educandoweb.curso.repositorios.OrderRepository;
import com.educandoweb.curso.repositorios.ProductRepository;
import com.educandoweb.curso.repositorios.UserRepository;


@Configuration
@Profile("test") // Nesse @ informar que é apenas para teste como já informado application.properties
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private OrdemItemRepository ordemItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3 ,p4 ,p5));
		
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(3, "Erivelton Reis", "eri@gmail.com", "9889977785", "12548780");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPreco());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPreco());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPreco());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPreco());
	
		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T22:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}

}
