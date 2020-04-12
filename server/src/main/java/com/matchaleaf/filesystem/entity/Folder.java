package com.matchaleaf.filesystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOLDER_ID")
	private Integer id;

	@Column(unique = true)
	private String name;

	@ManyToOne
	private Folder parentFolder;

	@OneToMany(orphanRemoval=true)
	private Set<Folder> childFolders; 

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	private Set<File> files;

	public Folder(Set<File> files, String name, Folder parentFolder, Set<Folder> childFolders) {
		
		this.files = files;
		this.name = name;
		this.parentFolder = parentFolder;
		this.childFolders = childFolders;
	}

	public Set<Folder> getFolders() {
		return childFolders;
	}

	public void setFolders(Set<Folder> childFolders) {
		this.childFolders = childFolders;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	public Folder() {
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

}
