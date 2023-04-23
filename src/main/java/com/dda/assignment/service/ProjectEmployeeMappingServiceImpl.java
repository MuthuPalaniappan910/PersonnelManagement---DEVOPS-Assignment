package com.dda.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.assignment.dto.ProjectEmployee;
import com.dda.assignment.dto.ProjectEmployeeResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoEmployeeProjectFoundException;
import com.dda.assignment.model.Employee;
import com.dda.assignment.model.Project;
import com.dda.assignment.model.ProjectEmployeeMapping;
import com.dda.assignment.repository.ProjectEmployeeMappingRepository;
import com.dda.assignment.utils.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectEmployeeMappingServiceImpl implements ProjectEmployeeMappingService {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectEmployeeMappingRepository projectEmployeeMappingRepository;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public ProjectEmployeeResponse getEmployeeProjectDetails(Long projectId) throws InvalidProjectException, NoEmployeeProjectFoundException {
		Project project = projectService.getProjectDetails(projectId);
		ProjectEmployeeResponse projectEmployeeResponse = new ProjectEmployeeResponse();
		List<ProjectEmployee> projectEmployees = new ArrayList<>();
		List<ProjectEmployeeMapping> projectEmployeeMappings = 
				projectEmployeeMappingRepository.findByProject(project);
		if(projectEmployeeMappings.isEmpty()) {
			throw new NoEmployeeProjectFoundException(ApplicationConstants.NO_EMPLOYEE_PROJECT_FOUND);
		}
		projectEmployeeMappings.forEach(projectEmployeeMapping -> {
			try {
				Employee employee = employeeService.getEmployeeDetails(projectEmployeeMapping.getEmployee().getEmployeeId());
				ProjectEmployee projectEmployee = new ProjectEmployee();
				projectEmployee.setDesignation(employee.getDesignation());
				projectEmployee.setEmployeeId(employee.getEmployeeId());
				projectEmployee.setEmployeeName(employee.getEmployeeName());
				projectEmployees.add(projectEmployee);
				
			} catch (InvalidEmployeeException e) {
				log.info("Caught Invalid Employee Exception : " + e.getMessage());
			}
			
		});
		projectEmployeeResponse.setProjectEmployee(projectEmployees);
		projectEmployeeResponse.setProjectId(project.getProjectId());
		projectEmployeeResponse.setProjectName(project.getProjectName());
		return projectEmployeeResponse;
	}

}
