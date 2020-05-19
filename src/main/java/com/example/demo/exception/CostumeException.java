package com.example.demo.exception;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CostumeException {
	private Date timeStamp;
	private String message;
	private String Details;
	

}