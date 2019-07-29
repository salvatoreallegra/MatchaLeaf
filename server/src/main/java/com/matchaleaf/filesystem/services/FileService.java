package com.matchaleaf.filesystem.services;


import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.matchaleaf.filesystem.entity.*;

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
	IdResponseDto createFile(MultipartFile file, Integer folderId);
	
	
	FileDownloadDto downloadFileById(Integer id);
	
	FileDto trashFile(Integer Id);
	
	File downloadFileBytesById(Integer id);

	FileDto moveFile(Integer id, String name);	
	

}
