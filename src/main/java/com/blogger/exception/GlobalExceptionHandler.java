package com.blogger.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogger.payloads.Apiresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Apiresponse> resourseNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
		Apiresponse apiresponse=new Apiresponse(message,false);
		return new ResponseEntity<Apiresponse>(apiresponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidException(org.springframework.web.bind.MethodArgumentNotValidException ex){
		
		Map<String, String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname=((FieldError) error).getField();
			String message= error.getDefaultMessage();
			resp.putIfAbsent(fieldname, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
