package com.dda.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dda.assignment.dto.EmployeePerformanceResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoEmployeePerformanceFoundException;
import com.dda.assignment.exception.NoProjectFinanceFoundException;
import com.dda.assignment.service.PerformanceService;

@RequestMapping("/performance")
@RestController
public class PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeePerformanceResponse> getPerformanceDetails(@PathVariable Long employeeId) throws InvalidProjectException, NoProjectFinanceFoundException, InvalidEmployeeException, NoEmployeePerformanceFoundException {
		return new ResponseEntity<>(performanceService.getPerformanceDetails(employeeId), HttpStatus.OK);
	}

}
