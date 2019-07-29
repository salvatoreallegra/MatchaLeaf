package com.matchaleaf.filesystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.Folder;
import com.matchaleaf.filesystem.mapper.FileMapper;
import com.matchaleaf.filesystem.mapper.FolderMapper;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FolderService;

@Service
public class FolderServiceImpl implements FolderService {


	private FolderRepository folderRepository;
	
	private FolderMapper folderMapper;

	

	public FolderServiceImpl(FolderMapper folderMapper, FolderRepository folderRepository) {

		this.folderMapper = folderMapper;
		this.folderRepository = folderRepository;

	}

	public IdResponseDto createFolder(FolderUploadDto folderUploadDto) {
//		Folder folderObj = folderRepository.getOne(folderUploadDto.getParentFolderId());
//		Folder folder = new Folder();
//		folder.setName(folderUploadDto.getName());
//		folder.setParentFolder(folderObj);
//		folderRepository.saveAndFlush(folder);
//		folderRepository.saveAndFlush(folderObj);
		//extract list  
		//folder.setFolders(folders);
		
		System.out.println("Inside Service");
		System.out.println(folderUploadDto.getName() + folderUploadDto.getParentFolderId());

		return folderMapper.entityToDto(folderRepository.saveAndFlush(folderMapper.dtoToEntity(folderUploadDto)));

	}

	@Override
	public FolderDto getFolderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FolderDto> downloadZipFolder(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FolderDto downloadFolderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
