package com.matchaleaf.filesystem.dto;

public class FileDownloadDto {

	private String name;
	private byte[] data;

	public FileDownloadDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
