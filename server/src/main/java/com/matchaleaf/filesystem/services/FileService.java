package com.matchaleaf.filesystem.services;

import com.matchaleaf.filesystem.dto.FileRequestDto;
import com.matchaleaf.filesystem.dto.FileResponseDto;

public interface FileService {

	FileResponseDto createFile(FileRequestDto fileDto);

}
