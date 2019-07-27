package com.matchaleaf.filesystem.services.impl;

import java.io.IOException;

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
	public String createFile(MultipartFile file, Integer folderId) {
        try {
			System.out.println("Bytes*8**** " + file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("******************In Create File");
        System.out.println("******************I am folder id " + folderId);
		byte[] fileByteArray = "Any String you want".getBytes();
		
		FileUploadDto fileUploadDto = new FileUploadDto();
		fileUploadDto.setName("Jubby");
		fileUploadDto.setData(fileByteArray);
		fileUploadDto.setFolderId(1);
		
		System.out.println("******************I am file upload dto name" + fileUploadDto.getName());
		
		//Attempt to save file without all these damn layers, let's just do a simple save
		fileRepository.save(fileMapper.dtoToEntity(fileUploadDto));
		
		return "Possibly saved to database";

		//return fileMapper.entityToDto(fileRepository.save(fileMapper.dtoToEntity(fileUploadDto))); 

		// TODO Auto-generated method stub
	}

}
