package com.matchaleaf.filesystem.dto;

import java.util.List;

public class FolderDto {
	
	
	private Integer id;
	private String name;
	private List<FileDto> files;
	private List<FolderDto> folders;
	
	public FolderDto() {
		
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

	public List<FileDto> getFiles() {
		return files;
	}

	public void setFiles(List<FileDto> files) {
		this.files = files;
	}

	public List<FolderDto> getFolders() {
		return folders;
	}

	public void setFolders(List<FolderDto> folders) {
		this.folders = folders;
	}

}
