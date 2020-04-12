package com.matchaleaf.filesystem;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.entity.Folder;
import com.matchaleaf.filesystem.mapper.FileMapper;
import com.matchaleaf.filesystem.repository.*;
import com.matchaleaf.filesystem.services.FileService;
import com.matchaleaf.filesystem.services.impl.FileServiceImpl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilesystemApplication {
	
	
	@Autowired
	private FolderRepository folderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FileRepository fileRepository, FolderRepository folderRepository) {
		return (args) -> {
		};
	}

}
