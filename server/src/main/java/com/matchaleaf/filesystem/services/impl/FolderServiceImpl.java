package com.matchaleaf.filesystem.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchaleaf.filesystem.dto.FileDto;
import com.matchaleaf.filesystem.dto.FolderDownloadZipDto;
import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.entity.Folder;
import com.matchaleaf.filesystem.mapper.FileMapper;
import com.matchaleaf.filesystem.mapper.FolderMapper;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FolderService;

@Service
public class FolderServiceImpl implements FolderService {

	private FolderRepository folderRepository;
	private FileMapper fileMapper;
	private FolderMapper folderMapper;

	public FolderServiceImpl(FolderRepository folderRepository, FileMapper fileMapper, FolderMapper folderMapper) {
		super();
		this.folderRepository = folderRepository;
		this.fileMapper = fileMapper;
		this.folderMapper = folderMapper;
	}

	// download a folders entire file contents as a zip file
	public FolderDownloadZipDto downloadFolder(Integer id) {

		Folder folderToZip = folderRepository.getOne(id);
		Set<File> allFiles = folderToZip.getFiles();

		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

		ZipOutputStream zipOut = new ZipOutputStream(arrayOutputStream);

		for (File f : allFiles) {
			try {
				ZipEntry zipEntry = new ZipEntry(f.getName());
				zipOut.putNextEntry(zipEntry);
				zipOut.write(f.getFileBytes());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			zipOut.close();
			arrayOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FolderDownloadZipDto downloadZipDto = new FolderDownloadZipDto();
		downloadZipDto.setName(folderToZip.getName());
		downloadZipDto.setByteArray(arrayOutputStream.toByteArray());
		return downloadZipDto;
		// return arrayOutputStream.toByteArray();//repl;ace file output stream with
		// byteoutarrayoutputstream //saves to byte array
		// return byte array of file output stream

	}

	public IdResponseDto createFolder(FolderUploadDto folderUploadDto) {

		Folder parentFolder = folderRepository.getOne(folderUploadDto.getParentFolderId());
		Folder folder = new Folder();
		folder.setName(folderUploadDto.getName());
		folder.setParentFolder(parentFolder);
		// extract list

		Set parentFolderFolders = parentFolder.getFolders();
		parentFolderFolders.add(folder);
		parentFolder.setFolders(parentFolderFolders);

		folderRepository.saveAndFlush(folder);
		folderRepository.saveAndFlush(parentFolder);
		System.out.println("Inside Service");

		System.out.println("All Folders" + folder.getFolders());

		return folderMapper.entityToDto(folder);
	}

	@Override
	public FolderDto getFolderById(Integer id) {
		// TODO Auto-generated method stub

		// Get the Folder requested from controller/end point
		Folder folder = folderRepository.getOne(id);

		// Get Set of Files belonging to requested folder
		Set<File> fileSet = folder.getFiles();

		// Get set of Folders belonging to requested folder
		Set<Folder> folderSet = folder.getFolders();

		Set<FileDto> fileDtos = new HashSet<>();
		Set<FolderDto> folderDtos = new HashSet<>();

		for (File f : fileSet) {
			FileDto fi = fileMapper.entityToFileDto(f);
			fileDtos.add(fi);
		}
		for (Folder f : folderSet) {
			FolderDto fdt = folderMapper.entityToFolderDto(f);
			folderDtos.add(fdt);

		}

		FolderDto folderDto = new FolderDto();

		folderDto.setId(folder.getId());
		folderDto.setName(folder.getName());
		folderDto.setFiles(fileDtos);
		folderDto.setFolders(folderDtos);
		return folderDto;

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

	@Override
	public IdResponseDto sendFolderToTrash(Integer id) {

		Folder trashFolder = folderRepository.getOne(2);
		FolderDto folderDto = moveFolder(id, folderMapper.entityToFolderDto(trashFolder));

		IdResponseDto folderIdDto = new IdResponseDto();
		folderIdDto.setId(id);
		return folderIdDto;
	}

	@Override
	public FolderDto moveFolder(Integer id, FolderDto folderDto) {

		Folder folder = folderRepository.getOne(id);
		Folder originalParentFolder = folderRepository.getOne(folder.getParentFolder().getId());
		Folder destinationFolder = folderMapper.dtoToEntity(folderDto);

		Set<Folder> parentFolderFolders = originalParentFolder.getFolders();
		parentFolderFolders.remove(folder);
		originalParentFolder.setFolders(parentFolderFolders);
		folderRepository.save(originalParentFolder);

		Set<Folder> destinationFolderFolders = destinationFolder.getFolders();
		destinationFolderFolders.add(folder);
		destinationFolder.setFolders(destinationFolderFolders);
		folderRepository.save(destinationFolder);

		folder.setParentFolder(destinationFolder);
		folderRepository.save(folder);

		IdResponseDto folderIdDto = new IdResponseDto();
		folderIdDto.setId(id);

		return folderDto;
	}

	@Override
	public IdResponseDto restoreFolderFromTrash(Integer id) {
		// TODO Auto-generated method stub
		Folder folderToRestore = folderRepository.getOne(id);

		Folder trashFolder = folderRepository.getOne(2);
		
		  Folder rootFolder = folderRepository.getOne(1); // 
		  Set<Folder>  setOfFoldersInTrash = trashFolder.getFolders(); 
		  Set<Folder>  setOfFoldersInRoot = rootFolder.getFolders(); 
		  setOfFoldersInTrash.remove(folderToRestore); 
		  setOfFoldersInRoot.add(folderToRestore);
		  
		  trashFolder.setFolders(setOfFoldersInTrash); 
		  rootFolder.setFolders(setOfFoldersInRoot); 
		 folderToRestore.setParentFolder(rootFolder); 
		 folderRepository.saveAndFlush(folderToRestore); 
		  folderRepository.saveAndFlush(trashFolder); 
		  folderRepository.saveAndFlush(rootFolder); 
		  
		  IdResponseDto restoreFolderDto = new IdResponseDto();
		  restoreFolderDto.setId(folderToRestore.getId());
		 

		return restoreFolderDto;
	}

}
