package com.matchaleaf.filesystem.mapper;

import org.mapstruct.Mapper;
import com.matchaleaf.filesystem.dto.*;
import com.matchaleaf.filesystem.entity.File;

@Mapper(componentModel = "spring")
public interface FileMapper {

	// Convert our file upload dto to a file entity
	File dtoToEntity(FileUploadDto fileUploadDto);

	// This will return the IdResponse to File Service
	IdResponseDto entityToDto(File file);

	FileDto entityToFileDto(File file);

}
