package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "book_id")
	private String book_Id;
	@Column(name = "book_Name")
	private String bookName;
	@Column(name = "Author_Name")
	private String authorName;
	public int racNo;
	@ManyToOne(fetch = FetchType.LAZY)
	private Library lib;
}
