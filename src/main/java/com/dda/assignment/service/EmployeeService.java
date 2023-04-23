package com.dda.assignment.service;

import com.dda.assignment.dto.LoginRequest;
import com.dda.assignment.dto.LoginResponse;
import com.dda.assignment.dto.UpdateEmployeePassowrdRequest;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.exception.InvalidLoginException;
import com.dda.assignment.exception.LoginAuthorizationException;
import com.dda.assignment.model.Employee;

public interface EmployeeService {

	LoginResponse validateLogin(LoginRequest loginRequestDto) throws InvalidLoginException, LoginAuthorizationException;

	Employee getEmployeeDetails(Long employeeId) throws InvalidEmployeeException;

	void addEmployeeDetails(Employee employee);

	void updateEmployeePassword(UpdateEmployeePassowrdRequest updateEmployeePassowrdRequest) throws InvalidEmployeeException;

	void deleteEmployee(Long employeeId) throws InvalidEmployeeException;

}
