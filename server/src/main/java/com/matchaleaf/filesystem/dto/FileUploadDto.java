package com.matchaleaf.filesystem.dto;

public class FileUploadDto {

	public FileUploadDto() {

	}

	String name;
	Byte[] data;
	Integer folderId;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte[] getData() {
		return data;
	}

	public void setData(Byte[] data) {
		this.data = data;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}



}
