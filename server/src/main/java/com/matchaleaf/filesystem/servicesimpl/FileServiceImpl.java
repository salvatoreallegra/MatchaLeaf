package com.matchaleaf.filesystem.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.dto.FileDownloadDto;
import com.matchaleaf.filesystem.dto.FileDto;
import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.services.FileService;
//
public class FileServiceImpl implements FileService {
	
		FileRepository fileRepository;
		
		
		
	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
		
		this.fileRepository = fileRepository;
	}



	@Override
	public IdResponseDto createFile(FileUploadDto fileUploadDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileDownloadDto downloadFileById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
