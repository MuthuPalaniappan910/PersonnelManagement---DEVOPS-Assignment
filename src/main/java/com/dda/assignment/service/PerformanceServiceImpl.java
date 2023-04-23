package com.dda.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.assignment.dto.EmployeePerformance;
import com.dda.assignment.dto.EmployeePerformanceResponse;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.NoEmployeePerformanceFoundException;
import com.dda.assignment.model.Employee;
import com.dda.assignment.model.Performance;
import com.dda.assignment.repository.PerformanceRepository;
import com.dda.assignment.utils.ApplicationConstants;

@Service
public class PerformanceServiceImpl implements PerformanceService {
	
	@Autowired
	private PerformanceRepository performanceRepository;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public EmployeePerformanceResponse getPerformanceDetails(Long employeeId) throws InvalidEmployeeException, NoEmployeePerformanceFoundException {
		EmployeePerformanceResponse employeePerformanceResponse = new EmployeePerformanceResponse();
		List<EmployeePerformance> employeePerformances = new ArrayList<>();
		Employee employee = employeeService.getEmployeeDetails(employeeId);
		List<Performance> performances = performanceRepository.findByEmployee(employee);
		
		if(performances.isEmpty()) {
			throw new NoEmployeePerformanceFoundException(ApplicationConstants.NO_EMPLOYEE_PERFORMANCE_FOUND);
		}
		
		performances.forEach(performance -> {
			EmployeePerformance employeePerformance = new EmployeePerformance();
			employeePerformance.setPerformanceId(performance.getPerformanceId());
			employeePerformance.setPerformanceYear(performance.getPerformanceYear());
			employeePerformance.setRating(performance.getRating().getPerformanceRating());
			employeePerformances.add(employeePerformance);			
		});
		
		employeePerformanceResponse.setDesignation(employee.getDesignation());
		employeePerformanceResponse.setEmployeeId(employee.getEmployeeId());
		employeePerformanceResponse.setEmployeeName(employee.getEmployeeName());
		employeePerformanceResponse.setEmployeePerformances(employeePerformances);
		return employeePerformanceResponse;
	}

}
