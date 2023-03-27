package com.educandoweb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.repositorios.UserRepository;
import com.educandoweb.curso.entidade.User;

@Configuration
@Profile("test") // Nesse @ informar que é apenas para teste como já informado application.properties
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User( 1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		
		User u2 = new User( 2, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

	

}
