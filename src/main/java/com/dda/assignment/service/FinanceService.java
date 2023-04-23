package com.dda.assignment.service;

import com.dda.assignment.dto.ProjectFinanceResponse;
import com.dda.assignment.exception.InvalidProjectException;
import com.dda.assignment.exception.NoProjectFinanceFoundException;

public interface FinanceService {

	ProjectFinanceResponse getFinanceDetails(Long projectId) throws InvalidProjectException, NoProjectFinanceFoundException;

}
