package com.customer.demo.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<APIError> customerNotFoundExceptionHandler(CustomerNotFoundException e,HttpServletRequest req){
		System.out.println("Handle");
		APIError ap=new APIError();
		ap.setDate(new Date());
		ap.setStatusCode(HttpStatus.NOT_FOUND.value());
		ap.setMessage(e.getMessage());
		ap.setPath(req.getRequestURI());
		ap.setHttpmessage(HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<APIError>(ap,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmeticExceptionHandler(ArithmeticException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	//handle the validation for the data input from model/customer validation annotations 
	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String , String> resp= new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName= ((FieldError)error).getField();
			String message= error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	

}
