package com.dda.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dda.assignment.dto.ExceptionResponse;
import com.dda.assignment.utils.ApplicationConstants;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidLoginException.class)
	public ResponseEntity<ExceptionResponse> invalidLoginException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.INVALID_LOGIN_MESSAGE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(LoginAuthorizationException.class)
	public ResponseEntity<ExceptionResponse> loginAuthorizationException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.LOGIN_INVALID_AUTHORIZATION_MESSAGE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<ExceptionResponse> incorrectPasswordException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.PASSWORD_MISMATCH);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(InvalidProjectException.class)
	public ResponseEntity<ExceptionResponse> invalidProjectException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.INVALID_PROJECT_MESSAGE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(NoProjectFinanceFoundException.class)
	public ResponseEntity<ExceptionResponse> noProjectFinanceFoundException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.NO_PROJECT_FINANCE_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(InvalidEmployeeException.class)
	public ResponseEntity<ExceptionResponse> invalidEmployeeException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.INVALID_EMPLOYEE_MESSAGE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(NoEmployeePerformanceFoundException.class)
	public ResponseEntity<ExceptionResponse> noEmployeePerformanceFoundException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.NO_EMPLOYEE_PERFORMANCE_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(NoEmployeeProjectFoundException.class)
	public ResponseEntity<ExceptionResponse> noEmployeeProjectFoundException() {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ApplicationConstants.NO_EMPLOYEE_PROJECT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

}
