//package com.matchaleaf.filesystem.controllers;
//
//import org.springframework.web.bind.annotation.*;
//
//import com.matchaleaf.filesystem.dto.FileRequestDto;
//import com.matchaleaf.filesystem.dto.FileResponseDto;
//import com.matchaleaf.filesystem.services.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/files")
//public class FileController {
//
//	private FileService fileService;
//
//	public FileController(FileService fileService) {
//		this.fileService = fileService;
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