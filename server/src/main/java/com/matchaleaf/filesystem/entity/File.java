package com.matchaleaf.filesystem.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
public class File {

	public File() {

	}

	public File(Integer id, String name, byte[] fileBytes, Folder parentFolder) {
		this.id = id;
		this.name = name;
		this.fileBytes = fileBytes;
		this.parentFolder = parentFolder;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@JoinColumn
	private String name;

	private byte[] fileBytes;

	@ManyToOne
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
