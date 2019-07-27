package com.matchaleaf.filesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

	
	
	

}
