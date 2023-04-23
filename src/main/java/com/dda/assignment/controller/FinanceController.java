package com.dda.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dda.assignment.dto.ProjectFinanceResponse;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoProjectFinanceFoundException;
import com.dda.assignment.service.FinanceService;

@RequestMapping("/finance")
@RestController
public class FinanceController {
	
	@Autowired
	private FinanceService financeService;
	
	@GetMapping("/{projectId}")
	public ResponseEntity<ProjectFinanceResponse> getFinanceDetails(@PathVariable Long projectId) throws InvalidProjectException, NoProjectFinanceFoundException {
		return new ResponseEntity<>(financeService.getFinanceDetails(projectId), HttpStatus.OK);
	}

}
