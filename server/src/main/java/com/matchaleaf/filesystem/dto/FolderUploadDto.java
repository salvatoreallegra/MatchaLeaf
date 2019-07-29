package com.matchaleaf.filesystem.dto;

public class FolderUploadDto {

	private String name;

	private Integer parentFolderId;

	public FolderUploadDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentFolderId() {
		return parentFolderId;
	}

	public void setParentFolderId(Integer parentFolderId) {
		this.parentFolderId = parentFolderId;
	}

}
