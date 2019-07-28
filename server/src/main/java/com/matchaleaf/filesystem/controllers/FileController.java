package com.matchaleaf.filesystem.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cooksys.orm.dto.StudentResponseDto;
import com.matchaleaf.filesystem.dto.FileDownloadDto;
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
	public FileDownloadDto downloadFile(@PathVariable Integer ID) {

		System.out.println("Im the id in the controller " + ID);
		// Load file from database
		return fileService.downloadFileById(ID);

	}

	// This may be what we eventually download, I don't think the downloadFile
	// Method will work because it returns the bytes as text

	@GetMapping("/bytes/{idbytes}")
	public ResponseEntity<Resource> downloadFileBytes(@PathVariable Integer idbytes) {

		File file = fileService.downloadFileBytesById(idbytes);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
				.body(new ByteArrayResource(file.getFileBytes()));
	}
	
	  @PatchMapping("/{id}/trash")
	    public StudentResponseDto updateStudentMajor(@PathVariable Integer id, @PathVariable String majorName) {
	        return studentSerive.updateStudentMajor(id, majorName);
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