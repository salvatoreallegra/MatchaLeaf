package com.matchaleaf.filesystem.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.dto.FileDownloadDto;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.entity.Folder;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FileService;
import com.matchaleaf.filesystem.mapper.*;

//
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private FolderRepository folderRepository;
	private FileMapper fileMapper;

//	@Autowired
//	Folder parentFolder;

	// private IdResponseDto testDto;
	public FileServiceImpl() {

	}

	public FileServiceImpl(FileRepository fileRepository, FileMapper fileMapper, FolderRepository folderRepository) {

		this.fileRepository = fileRepository;
		this.fileMapper = fileMapper;
		this.folderRepository = folderRepository;

	}

	@Override
	public FileDownloadDto downloadFileById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createFile(MultipartFile file, Integer folderId) {

		Folder parentFolder = new Folder();
		parentFolder = folderRepository.getOne(folderId);
		File fileEntity = new File();

		fileEntity.setName(file.getOriginalFilename());
		try {
			fileEntity.setFileBytes(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileEntity.setParentFolder(parentFolder);
		// fileEntity.setParentFolderId(folderId);

		fileRepository.save(fileEntity);

		return "Possibly saved to database";
	}

}
