package com.matchaleaf.filesystem;

import java.util.HashSet;
import java.util.Set;

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
	// private FolderRepository folderRepository;

//	static byte[] fileByteArray = "Any String you want".getBytes();

	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(FileRepository fileRepository, FolderRepository folderRepository) {
		return (args) -> {

//			Set<File> fileSet = new HashSet<>();
//			Folder root = new Folder(null, "root", null);
//			Folder trash = new Folder(null, "trash", null);
//			folderRepository.save(root);
//			folderRepository.save(trash);
//			
			
//			// Set of files
//			
//			// One File
//			File docFile = new File("Tracks.txt", fileByteArray, folder);
//			File musicFile = new File("Mozart", fileByteArray,folder);
//
//			// Add a file to the set
//			fileSet.add(docFile);
//			fileSet.add(musicFile);
//
//			// I am going to be root with no parent
//
//			folderRepository.save(folder);
//
//			fileRepository.save(new File("I have no parent", fileByteArray, null));
//
//			fileRepository.save(new File("I have a parent", fileByteArray, folder));


			
			
			
			
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
