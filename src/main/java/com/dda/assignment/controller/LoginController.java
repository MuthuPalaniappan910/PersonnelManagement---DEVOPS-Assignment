package com.dda.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dda.assignment.dto.LoginRequest;
import com.dda.assignment.dto.LoginResponse;
import com.dda.assignment.exception.InvalidLoginException;
import com.dda.assignment.exception.LoginAuthorizationException;
import com.dda.assignment.service.EmployeeService;

@RequestMapping("/login")
@RestController
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<LoginResponse> validateLogin(@RequestBody LoginRequest loginRequestDto)
			throws InvalidLoginException, LoginAuthorizationException {		
		return new ResponseEntity<>(employeeService.validateLogin(loginRequestDto), HttpStatus.OK);
	}	

}
