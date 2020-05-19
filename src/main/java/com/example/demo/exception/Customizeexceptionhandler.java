package com.example.demo.exception;


import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class Customizeexceptionhandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		CostumeException exceptionalRessponse= new CostumeException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(exceptionalRessponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) throws Exception {
		
		CostumeException exceptionalRessponse= new CostumeException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(exceptionalRessponse,HttpStatus.NO_CONTENT);	
	}
	
	 @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		 CostumeException exceptionalRessponse= new CostumeException(new Date(),"Invalid Message Error",ex.getBindingResult().toString());
		 return new ResponseEntity<>(exceptionalRessponse,HttpStatus.BAD_REQUEST);		}	
	
	

}
