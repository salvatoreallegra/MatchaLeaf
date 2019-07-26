package com.matchaleaf.filesystem.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


//import com.matchaleaf.filesystem.mapper.FileMapper;

import com.matchaleaf.filesystem.dto.FileDownloadDto;

import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FileService;

//
@Service
public class FileServiceImpl implements FileService {

	private FileRepository fileRepository;
	private FolderRepository folderRepository;
	//private FileMapper fileMapper;

	@Autowired
	public FileServiceImpl(FileRepository fileRepository, FolderRepository folderRepository) {

		this.fileRepository = fileRepository;
		this.folderRepository = folderRepository;
	}

	@Override
	public FileDownloadDto downloadFileById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String/*IdResponseDto*/ createFile(MultipartFile file, Integer folderID/* FileUploadDto fileUploadDto */) {
		System.out.println("99999999999" + file.getOriginalFilename());
	
		// TODO Auto-generated method stub
		return "hello";
	}

}
