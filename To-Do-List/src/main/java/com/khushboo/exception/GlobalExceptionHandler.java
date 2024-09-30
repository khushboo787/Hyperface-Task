package com.khushboo.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<ErrorDetails> methodArgumentInvalidHandler(MethodArgumentNotValidException e, WebRequest req) {
		log.error("Invalid data for user object");
		
		ErrorDetails ed = new ErrorDetails();		
		ed.setTimestamp(LocalDateTime.now());
		List<ObjectError> allErrors = e.getAllErrors();
		String message = String.join(", ", allErrors.toString());
		ed.setMessage(message);
		ed.setUri(req.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex, WebRequest req) {
		ErrorDetails ed = new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(ex.getMessage());
		ed.setUri(req.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(TaskNotFoundException.class) 
	public ResponseEntity<ErrorDetails> taskNotFoundExceptionHandler(TaskNotFoundException ex, WebRequest req) {
		ErrorDetails ed = new ErrorDetails();
		
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(ex.getMessage());
		ed.setUri(req.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	

    
}