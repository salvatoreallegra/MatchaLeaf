package com.matchaleaf.filesystem.dto;

import java.util.List;
import java.util.Set;

import com.matchaleaf.filesystem.entity.File;
import com.matchaleaf.filesystem.entity.Folder;

public class FolderDto {

	private Integer id;
	private String name;
	private Set<FileDto> files;
	private Set<FolderDto> folders;

	public FolderDto() {

	}

	public FolderDto(Integer id, String name, Set<FileDto> files, Set<FolderDto> folders) {
		super();
		this.id = id;
		this.name = name;
		this.files = files;
		this.folders = folders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FileDto> getFiles() {
		return files;
	}

	public void setFiles(Set<FileDto> files) {
		this.files = files;
	}

	public Set<FolderDto> getFolders() {
		return folders;
	}

	public void setFolders(Set<FolderDto> folders) {
		this.folders = folders;
	}

}
