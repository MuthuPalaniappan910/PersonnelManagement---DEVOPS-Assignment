package com.dda.assignment.dto;

public class NewEmployeeRequest {	
	
	private String employeeName;
	private String designation;
	private Double yearsOfExperience;
	private String password;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
