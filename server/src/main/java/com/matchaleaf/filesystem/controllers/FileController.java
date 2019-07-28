package com.matchaleaf.filesystem.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.services.*;

import java.io.IOException;
import java.util.List;

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

	// Keep getting unsupported media type exception in postman, this has something
	// to do with
	// headers when I use @RequestBody

	@PostMapping
	public String createFile(@RequestParam("file") MultipartFile file,
			@RequestParam(name = "parentFolderId") Integer folderId) {
		if(folderId == null) {			
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

//	@PostMapping("/test")
//	public String createFileTest(@RequestParam("file") MultipartFile file,
//			@RequestParam(name = "parentFolderId") Integer folderId) {
//		System.out.println("Parent Folder id  " + folderId);
//
//		return fileService.createFile(file, folderId);
//		// return "Hello";
//
//	}

//    @GetMapping
//    public List<CourseResponseDto> getAllCourses() {
//        return courseService.getAllCourses();
//    }

//	@PostMapping
//	public FileResponseDto createFile(@RequestBody FileRequestDto fileDto) {
//		return fileService.createFile(fileDto);
//	}

//    @GetMapping("/{id}")
//    public CourseResponseDto readCourse(@PathVariable Integer id) {
//        return courseService.readCourse(id);
//    }
//
//    @PutMapping("/{id}")
//    public CourseResponseDto updateCourse(@PathVariable Integer id, @RequestBody CourseRequestDto courseDto) {
//        return courseService.updateCourse(id, courseDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public CourseResponseDto deleteCourse(@PathVariable Integer id) {
//        return courseService.deleteCourse(id);
//    }
}