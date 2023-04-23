package com.dda.assignment.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.model.Project;
import com.dda.assignment.repository.ProjectRepository;
import com.dda.assignment.utils.ApplicationConstants;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project getProjectDetails(Long projectId) throws InvalidProjectException {
		Project project = projectRepository.findByProjectId(projectId);
		if(Objects.nonNull(project)) {
			return project;
		}
		throw new InvalidProjectException(ApplicationConstants.INVALID_PROJECT_MESSAGE);
	}

}
