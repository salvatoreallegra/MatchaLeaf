package com.matchaleaf.filesystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;

@Service
public interface FolderService {
	
// The dto's we need
//      IDResponseDto
//		FileUploadDto
//		FolderUploadDto
//		FileDownloadDto --This will have the bytes the actual bytes as well
//		FileDto   ---This is related to the photo Pedro sent me in slack
//		FolderDto
	
	   IdResponseDto createFolder(FolderUploadDto folderUploadDto);
	   
	   FolderDto getFolderById(Integer id);
	   
	   
	   
	   /*
	    * The json response for FolderDto will be
	    * 
	    * 
	    * {
		*  id: integer,
		*  name: string,
		*  files: [ File ],
		*  folders: [ Folder ],
		* }
	    * 
	    * 
	    * 
	    */
	   	FolderDto downloadFolderById(Integer id);
	   	
	    List<FolderDto> downloadZipFolder(Integer id);

		IdResponseDto sendFolderToTrash(Integer id);

		FolderDto moveFolder(Integer id, FolderDto folderDto);


}


   