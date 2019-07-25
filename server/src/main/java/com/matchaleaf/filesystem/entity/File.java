package com.matchaleaf.filesystem.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
public class File {

	public File() {

	}

	public File(String name, byte[] fileBytes, Folder parentFolder) {

		this.name = name;
		this.fileBytes = fileBytes;
		this.parentFolder = parentFolder;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private Integer id;

	@Column(unique = true)
	private String name;

	private byte[] fileBytes;

	@ManyToOne
	@JoinColumn(name = "FOLDER_ID")
	private Folder parentFolder;

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

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

}
