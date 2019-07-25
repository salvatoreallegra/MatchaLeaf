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

	static byte[] fileByteArray = "Any String you want".getBytes();

	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(FileRepository fileRepository, FolderRepository folderRepository) {
		return (args) -> {
			//Create a root folder *Root folder will just be sitting in database
			folderRepository.save(new Folder(null,"root",null));
			fileRepository.save(new File("Docs", fileByteArray, null));
			fileRepository.save(new File("Photos", fileByteArray,null));


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
