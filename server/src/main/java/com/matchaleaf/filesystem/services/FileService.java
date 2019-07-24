package com.matchaleaf.filesystem.services;

import com.cooksys.orm.dto.CourseRequestDto;
import com.cooksys.orm.dto.CourseResponseDto;
import com.matchaleaf.filesystem.dto.FileDto;
import com.matchaleaf.filesystem.repository.DBFileRepository;

public interface FileService {
	
	
	 FileResponseDto createFile(FileRequestDto fileDto);

}
