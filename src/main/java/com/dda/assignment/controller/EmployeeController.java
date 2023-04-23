package com.dda.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dda.assignment.dto.NewEmployeeRequest;
import com.dda.assignment.dto.ProjectEmployee;
import com.dda.assignment.dto.UpdateEmployeePassowrdRequest;
import com.dda.assignment.exception.IncorrectPasswordException;
import com.dda.assignment.exception.InvalidEmployeeException;
import com.dda.assignment.model.Employee;
import com.dda.assignment.service.EmployeeService;
import com.dda.assignment.utils.ApplicationConstants;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<ProjectEmployee> getEmployeeDetails(@PathVariable Long employeeId) throws InvalidEmployeeException {
		Employee employee = employeeService.getEmployeeDetails(employeeId);
		ProjectEmployee projectEmployee = new ProjectEmployee();
		projectEmployee.setDesignation(employee.getDesignation());
		projectEmployee.setEmployeeId(employee.getEmployeeId());
		projectEmployee.setEmployeeName(employee.getEmployeeName());
		return new ResponseEntity<>(projectEmployee, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployeeDetails(@RequestBody NewEmployeeRequest newEmployeeRequest){
		Employee employee = new Employee();
		employee.setDesignation(newEmployeeRequest.getDesignation());
		employee.setEmployeeName(newEmployeeRequest.getEmployeeName());
		employee.setPassword(newEmployeeRequest.getPassword());
		employee.setYearsOfExperience(newEmployeeRequest.getYearsOfExperience());
		employeeService.addEmployeeDetails(employee);
		return new ResponseEntity<>("Employee Details Saved Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updatepassword")
	public ResponseEntity<String> updateEmployeePassword(@RequestBody UpdateEmployeePassowrdRequest updateEmployeePassowrdRequest) throws IncorrectPasswordException, InvalidEmployeeException{
		if (updateEmployeePassowrdRequest.getNewPassword().equals(updateEmployeePassowrdRequest.getConfirmNewPassword())){
			employeeService.updateEmployeePassword(updateEmployeePassowrdRequest);
			return new ResponseEntity<>("Employee Password Updated Successfully", HttpStatus.OK);
		}
		throw new IncorrectPasswordException(ApplicationConstants.PASSWORD_MISMATCH);		
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) throws InvalidEmployeeException{
			employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<>("Employee deleted Successfully", HttpStatus.OK);		
	}

}
