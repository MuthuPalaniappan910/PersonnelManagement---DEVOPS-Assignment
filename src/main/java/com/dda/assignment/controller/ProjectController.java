package com.dda.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dda.assignment.dto.ProjectEmployeeResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoEmployeeProjectFoundException;
import com.dda.assignment.service.ProjectEmployeeMappingService;

@RequestMapping("/project")
@RestController
public class ProjectController {
	
	@Autowired
	private ProjectEmployeeMappingService projectEmployeeMappingService;
	
	@GetMapping("/{projectId}")
	public ResponseEntity<ProjectEmployeeResponse> getEmployeeProjectDetails(@PathVariable Long projectId) throws InvalidProjectException, NoEmployeeProjectFoundException, InvalidEmployeeException {
		return new ResponseEntity<> (projectEmployeeMappingService.getEmployeeProjectDetails(projectId), HttpStatus.OK);
	}

}
