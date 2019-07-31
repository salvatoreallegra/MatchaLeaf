package com.matchaleaf.filesystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matchaleaf.filesystem.dto.FolderDownloadZipDto;
import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;

@Service
public interface FolderService {

	IdResponseDto createFolder(FolderUploadDto folderUploadDto);

	IdResponseDto sendFolderToTrash(Integer id);

	FolderDto getFolderById(Integer id);
	
	/*
	 * The json response for FolderDto will be
	 * 
	 * 
	 * { id: integer, name: string, files: [ File ], folders: [ Folder ], }
	 * 
	 * 
	 * 
	 */
	FolderDownloadZipDto downloadFolder(Integer id);
	
	FolderDto downloadFolderById(Integer id);

	List<FolderDto> downloadZipFolder(Integer id);
	
	IdResponseDto restoreFolderFromTrash(Integer id);

	IdResponseDto moveFolder(Integer id, Integer destinationId);

}
