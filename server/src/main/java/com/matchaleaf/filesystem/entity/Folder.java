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
	
	
	/****************
	 * Cascade all will allow saving of Files 
	 * without explicitly calling file.save	 
	 */

   
	//@JoinColumn(name = "FOLDER_ID")
	@ManyToOne
	private Folder parentFolder;
	
	

//	@OneToMany
	@OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "FILE_ID")
	private Set<File> files;

	public Folder() {
	}

	public Folder(Set<File> files, String name, Folder parentFolder) {
		//this.id = id;
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



}
