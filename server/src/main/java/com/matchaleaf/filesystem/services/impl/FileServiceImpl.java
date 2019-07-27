package com.matchaleaf.filesystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.matchaleaf.filesystem.dto.FileDownloadDto;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FileService;
import com.matchaleaf.filesystem.mapper.*;

//
@Service
public class FileServiceImpl implements FileService {

	private FileRepository fileRepository;
	private FolderRepository folderRepository;
	private FileMapper fileMapper;

	//private IdResponseDto testDto;
	public FileServiceImpl() {
		
	}

	
	public FileServiceImpl(FileRepository fileRepository, FileMapper fileMapper, FolderRepository folderRepository ) {

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
	public IdResponseDto createFile(MultipartFile file, Integer folderId) {

		byte[] fileByteArray = "Any String you want".getBytes();
		FileUploadDto fileUploadDto = new FileUploadDto();
		fileUploadDto.setName("Jubby");
		fileUploadDto.setData(fileByteArray);
		fileUploadDto.setFolderId(1);

		return fileMapper.entityToDto(fileRepository.saveAndFlush(fileMapper.dtoToEntity(fileUploadDto))); 

		// TODO Auto-generated method stub
	}

}
