package com.dda.assignment.service;

import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.model.Project;

public interface ProjectService {

	Project getProjectDetails(Long projectId) throws InvalidProjectException;

}
