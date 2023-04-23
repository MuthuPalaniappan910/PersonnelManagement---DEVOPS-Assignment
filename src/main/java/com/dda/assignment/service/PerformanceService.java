package com.dda.assignment.service;

import com.dda.assignment.dto.EmployeePerformanceResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.NoEmployeePerformanceFoundException;

public interface PerformanceService {

	EmployeePerformanceResponse getPerformanceDetails(Long employeeId) throws InvalidEmployeeException, NoEmployeePerformanceFoundException;

}
