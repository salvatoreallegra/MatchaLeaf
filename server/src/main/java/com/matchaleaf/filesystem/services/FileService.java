package com.matchaleaf.filesystem.services;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.*;
@Service
public interface FileService {

// The dto's we need
// IDResponseDto
//	FileUploadDto
//	FolderUploadDto
//	FileDownloadDto --This will have the bytes the actual bytes as well
//	FileDto   ---This is related to the photo Pedro sent me in slack
//	FolderDto
//

	//This is can also be considered uploading a file
	String createFile(MultipartFile file);   
	FileDownloadDto downloadFileById(Integer id);
	
	

}
