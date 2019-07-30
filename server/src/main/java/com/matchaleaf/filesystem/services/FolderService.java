package com.matchaleaf.filesystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;

@Service
public interface FolderService {

<<<<<<< HEAD
	IdResponseDto createFolder(FolderUploadDto folderUploadDto);
=======
		FolderDto moveFolder(Integer id, FolderDto folderDto);

>>>>>>> 7ce9a50600f99f467d24438d128e312acb6f1ad5

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
	FolderDto downloadFolderById(Integer id);

	List<FolderDto> downloadZipFolder(Integer id);

}
