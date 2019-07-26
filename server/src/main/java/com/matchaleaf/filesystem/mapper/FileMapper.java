package com.matchaleaf.filesystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.matchaleaf.filesystem.dto.*;

@Mapper(componentModel = "spring", uses = FolderMapper.class)
public interface FileMapper {
	
	
}
