package com.matchaleaf.filesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.matchaleaf.filesystem.entity.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer> {

	

}
