package com.matchaleaf.filesystem.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.services.FolderService;

@RestController
@RequestMapping(path = "/folders")
public class FolderController {
	
	private FolderService folderService;

	public FolderController(FolderService folderService) {
		this.folderService = folderService;
	}
	
	
	public String createFolder(@RequestBody FolderUploadDto folderUploadDto) {
		System.out.println(folderUploadDto.getFolderName());
		//return fileService.createFile(file, folderId);
		return "Hello";

	}

}
