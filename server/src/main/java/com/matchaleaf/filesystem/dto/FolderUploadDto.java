package com.matchaleaf.filesystem.dto;

public class FolderUploadDto {
	
	
	private String folderName;
	
	private Integer parentFolderId;
	
	public FolderUploadDto() {
		
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public Integer getParentFolderId() {
		return parentFolderId;
	}

	public void setParentFolderId(Integer parentFolderId) {
		this.parentFolderId = parentFolderId;
	}
	
	
	
	
	

}
