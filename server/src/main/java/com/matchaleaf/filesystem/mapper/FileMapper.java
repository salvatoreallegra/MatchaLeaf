package com.matchaleaf.filesystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FileMapper {
	
	File fileToFileDTo(File);
	
	File fileToFileDownloadDto(File);
	
	File fileToFileUploadDto(File);
	
	FileDto	fileDtoToFile(FileDto);
	
	FileUploadDto fileUploadDtoToFile(FileUploadDto);
	
	FileDownloadDto	fileDowloadDtoToFile(FileDownloadDto);
}
