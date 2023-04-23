package com.dda.assignment.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dda.assignment.dto.LoginRequest;
import com.dda.assignment.dto.LoginResponse;
import com.dda.assignment.dto.UpdateEmployeePassowrdRequest;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidLoginException;
import com.dda.assignment.exception.LoginAuthorizationException;
import com.dda.assignment.model.Employee;
import com.dda.assignment.repository.EmployeeRepository;
import com.dda.assignment.utils.ApplicationConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public LoginResponse validateLogin(LoginRequest loginRequest) 
			throws InvalidLoginException, LoginAuthorizationException {
		
		Employee employee = employeeRepository.findByEmployeeIdAndPassword(
				loginRequest.getEmployeeId(), loginRequest.getPassword());
		
		if(Objects.nonNull(employee)) {		
			if((employee.getDesignation().equalsIgnoreCase(ApplicationConstants.BRANCH_CEO)) 
					|| (employee.getDesignation().equalsIgnoreCase(ApplicationConstants.COMPANY_CEO))) {
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setDesignation(employee.getDesignation());
				loginResponse.setEmployeeId(employee.getEmployeeId());
				loginResponse.setEmployeeName(employee.getEmployeeName());
				loginResponse.setMessage(ApplicationConstants.LOGIN_SUCCESS_MESSAGE);
				return loginResponse;
			}		
				throw new LoginAuthorizationException(ApplicationConstants.LOGIN_INVALID_AUTHORIZATION_MESSAGE);
		}
		throw new InvalidLoginException(ApplicationConstants.INVALID_LOGIN_MESSAGE);
	}

	@Override
	public Employee getEmployeeDetails(Long employeeId) throws InvalidEmployeeException {
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		if(Objects.nonNull(employee)) {
			return employee;
		}
		throw new InvalidEmployeeException(ApplicationConstants.INVALID_EMPLOYEE_MESSAGE);
	}

	@Override
	public void addEmployeeDetails(Employee employee) {
		Long Id = employeeRepository.getMaxEmployeeId();
		employee.setEmployeeId(Id+1);
		employeeRepository.save(employee);		
	}

	@Override
	public void updateEmployeePassword(UpdateEmployeePassowrdRequest updateEmployeePassowrdRequest) throws InvalidEmployeeException{
		Employee employee = getEmployeeDetails(updateEmployeePassowrdRequest.getEmployeeId());
		employee.setPassword(updateEmployeePassowrdRequest.getNewPassword());
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) throws InvalidEmployeeException {
		Employee employee = getEmployeeDetails(employeeId);
		employeeRepository.delete(employee);
		
	}

}
