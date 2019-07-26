package com.matchaleaf.filesystem.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.mapper.FileMapper;
import com.cooksys.orm.mapper.StudentMapper;
import com.cooksys.orm.repository.CourseRepository;
import com.cooksys.orm.repository.MajorRepository;
import com.cooksys.orm.repository.StudentRepository;
import com.matchaleaf.filesystem.dto.FileDownloadDto;
import com.matchaleaf.filesystem.dto.FileDto;
import com.matchaleaf.filesystem.dto.FileUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.repository.FileRepository;
import com.matchaleaf.filesystem.repository.FolderRepository;
import com.matchaleaf.filesystem.services.FileService;

//
public class FileServiceImpl implements FileService {

	private FileRepository fileRepository;
	private FolderRepository folderRepository;
	private FileMapper fileMapper;

	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {

		this.fileRepository = fileRepository;
	}

	@Override
	public FileDownloadDto downloadFileById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdResponseDto createFile(MultipartFile file, FileUploadDto fileUploadDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
