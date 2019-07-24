package com.matchaleaf.filesystem.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
public class File {
	
	public File() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String name;

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


}
