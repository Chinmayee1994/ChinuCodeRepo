package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.example.demo.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "li_Library")

 //@TypeDef( name = "jsonb", typeClass =JsonBinaryType.class )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Li_No")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int liNo;
	@Column(name = "Li_Name")  
	@ApiModelProperty(notes = "Field Should be more than 2")
	@Size(min=2,max=220,message = "Field Should be more than 2 ")
	private String LiName;
	@OneToMany(mappedBy = "lib")
	private List<Book>books;
	/*
	 * @Column(name = "book_id") private String book_Id;
	 * 
	 * @Column(name = "book_Name")
	 * 
	 * @JsonIgnore private String bookName;
	 */
    //@Type(type="jsonb") @Column( name = "book_info", columnDefinition = "jsonb", nullable = false )
	//private BookDto bookinfo;

}
