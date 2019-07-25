package com.matchaleaf.filesystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.entity.Folder;
import com.matchaleaf.filesystem.repository.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilesystemApplication {
	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	static
	 FileRepository fileRepository;
	
	static byte[] fileByteArray = "Any String you want".getBytes();

	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);
		
		
	}	
	@Bean
	public CommandLineRunner demo(FileRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new File(1, "Docs", fileByteArray, null));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1L)
//				.ifPresent(customer -> {
//					log.info("Customer found with findById(1L):");
//					log.info("--------------------------------");
//					log.info(customer.toString());
//					log.info("");
//				});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
		};
	}



}
