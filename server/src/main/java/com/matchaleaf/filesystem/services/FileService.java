package com.matchaleaf.filesystem.services;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.*;

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
	IdResponseDto createFile(FileUploadDto fileUploadDto);   
	FileDownloadDto downloadFileById(Integer id);
	
	

}
