package com.matchaleaf.filesystem.mapper;

import org.mapstruct.Mapper;

import com.matchaleaf.filesystem.dto.FolderDto;
import com.matchaleaf.filesystem.dto.FolderUploadDto;
import com.matchaleaf.filesystem.dto.IdResponseDto;
import com.matchaleaf.filesystem.entity.Folder;

@Mapper(componentModel = "spring")
public interface FolderMapper {

	IdResponseDto entityToDto(Folder folder);

	Folder dtoToEntity(FolderUploadDto folderUploadDto);

	FolderDto entityToFolderDto(Folder folder);

}
