package com.matchaleaf.filesystem.controllers;

import org.springframework.core.io.ByteArrayResource;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.FileDownloadDto;
import com.matchaleaf.filesystem.dto.FileDto;
import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.services.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/files")
public class FileController {
//
	private FileService fileService;

	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	@GetMapping
	public String sayHello() {
		return "Hello";
	}

	@PostMapping
	public IdResponseDto createFile(@RequestParam("file") MultipartFile file,
			@RequestParam(name = "parentFolderId") Integer folderId) {
		if (folderId == null) {
			folderId = 1;
		}
		if (folderId instanceof Integer) {
			System.out.println("Folder id is integer");
		} else {
			System.out.println("Not an integer");
		}

		System.out.println("Parent Folder id  " + folderId);

		return fileService.createFile(file, folderId);
	}

	@GetMapping("/{ID}")
	public ResponseEntity<Resource> downloadFileBytes(@PathVariable Integer ID) {

		File file = fileService.downloadFileBytesById(ID);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
				.body(new ByteArrayResource(file.getFileBytes()));
	}

	@PatchMapping("/{id}/trash")
	public FileDto trashFile(@PathVariable Integer id) {
		return fileService.trashFile(id);
	}

	@PatchMapping("/move")
	public FileDto moveFile(@RequestBody FileDto filePatchDto) {
		Integer id = filePatchDto.getId();
		String name = filePatchDto.getName();
		return fileService.moveFile(id, name);
	}

}