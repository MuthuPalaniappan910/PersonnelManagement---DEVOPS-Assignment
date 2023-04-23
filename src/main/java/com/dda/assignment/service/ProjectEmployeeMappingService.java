package com.dda.assignment.service;

import com.dda.assignment.dto.ProjectEmployeeResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoEmployeeProjectFoundException;

public interface ProjectEmployeeMappingService {

	ProjectEmployeeResponse getEmployeeProjectDetails(Long projectId) throws InvalidProjectException, NoEmployeeProjectFoundException, InvalidEmployeeException;

}
