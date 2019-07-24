package com.matchaleaf.filesystem.entity;

import javax.persistence.*;

import com.cooksys.orm.entity.Major;
import com.cooksys.orm.entity.Student;

import java.util.Set;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Folder folder;

    public File() {
    }

//    public File(String name) {
//        this.name = name;
//    }


}
