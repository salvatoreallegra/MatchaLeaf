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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String name;
	
	
	/****************
	 * Cascade all will allow saving of Files 
	 * without explicitly calling file.save	 
	 */

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "folder_id")
	private Folder parentFolder;

	@OneToMany
	@JoinColumn(name = "FILE_ID")
	private Set<File> files = new HashSet<File>();

	public Folder() {
	}

	public Folder(Set<File> files, String name, Folder parentFolder) {
		this.id = id;
		this.files = files;
		this.name = name;
		this.parentFolder = parentFolder;
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

	public Folder getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

}
