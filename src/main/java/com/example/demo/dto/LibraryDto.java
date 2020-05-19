package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "all obout model details")
//@JsonFilter("beanpropertyfilter")
public class LibraryDto implements Serializable {	
    private static final long serialVersionUID = -3627518286145703775L;
	private int liNo;
	@ApiModelProperty(notes = "Field Should be more than 4")
	@Size(min=2,max=220,message = "Field Should be more than 4 ")
	private String LiName;
	private String book_Id;
	private String bookName;
	//@JsonIgnore ->this annotation use for static filteration in response we can get this value
	private String authorName;
	private List<Book>books;
	
	
	
	
	

}
