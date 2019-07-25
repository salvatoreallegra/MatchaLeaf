package com.matchaleaf.filesystem.dto;

public class FileUploadDto {

	public FileUploadDto() {

	}

	String fileName;
	Byte[] fileBytes;
	String folderName;

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

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
