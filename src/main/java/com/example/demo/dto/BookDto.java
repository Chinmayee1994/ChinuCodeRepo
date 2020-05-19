package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entity.Library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto implements Serializable {
	
	private static final long serialVersionUID = -4993498019273799826L;
	
	private String book_Id;
	private String bookName;
	private String authorName;
	public int racNo;
	private Library lib;
	/*
	 * public String getBook_Id() { return book_Id; } public void setBook_Id(String
	 * book_Id) { this.book_Id = book_Id; } public String getBookName() { return
	 * bookName; } public void setBookName(String bookName) { this.bookName =
	 * bookName; } public String getAuthorName() { return authorName; } public void
	 * setAuthorName(String authorName) { this.authorName = authorName; }
	 */
	

}
