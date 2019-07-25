package com.matchaleaf.filesystem.services;

import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;

public interface FolderService {
	
// The dto's we need
//      IDResponseDto
//		FileUploadDto
//		FolderUploadDto
//		FileDownloadDto --This will have the bytes the actual bytes as well
//		FileDto   ---This is related to the photo Pedro sent me in slack
//		FolderDto
	
	   IdResponseDto createFolder(FolderUploadDto folderUploadDto);


}


   