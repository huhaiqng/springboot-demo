package com.hhq.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class AccessingdatamongodbApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingdatamongodbApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		
		System.out.println("Customers found with findAll():");
		System.out.println("#############################################");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		
		System.out.println("Customer found with findByFirstName('Alice');");
		System.out.println("#############################################");
		System.out.println(repository.findByFirstName("Alice"));
		
		System.out.println("Customer found with findByLastName('Smith');");
		System.out.println("#############################################");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

}
