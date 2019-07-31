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

	// This can also be considered uploading a file
	FileDto createFile(MultipartFile file, Integer folderId);

	FileDownloadDto downloadFileById(Integer id);

	FileDto trashFile(Integer Id);

	File downloadFileBytesById(Integer id);

	IdResponseDto moveFile(Integer id, Integer destinationId);
	
	IdResponseDto restoreFileFromTrash(Integer id);

}
