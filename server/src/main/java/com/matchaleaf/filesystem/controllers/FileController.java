package com.matchaleaf.filesystem.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.services.*;

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
	
	//Keep getting unsupported media type exception in postman, this has something to do with
	//headers when I use @RequestBody
	
	@PostMapping
	public IdResponseDto createFile(@RequestParam("file") MultipartFile file, @RequestBody Integer folderID) {
		System.out.println("88888888888888 " + file.getOriginalFilename());
		
		//return "Hello File";
		return fileService.createFile(file, folderID);
	}

	@PostMapping("/test")
	public IdResponseDto createFileTest(@RequestParam("file") MultipartFile file) {
		
		int folderID = 1;
		//return "Hello File";
		return fileService.createFile(file, folderID);
	}


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