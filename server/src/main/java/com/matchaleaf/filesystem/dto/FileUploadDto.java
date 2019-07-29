package com.matchaleaf.filesystem.dto;

public class FileUploadDto {

	public FileUploadDto() {

	}

	String name;
	byte[] data;
	Integer folderId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] fileByteArray) {
		this.data = fileByteArray;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

}
