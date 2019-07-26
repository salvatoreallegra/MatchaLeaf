package com.matchaleaf.filesystem.dto;

public class FileUploadDto {

	public FileUploadDto() {

	}

	String fileName;
	Byte[] fileBytes;
	Integer folderId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(Byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}



}
