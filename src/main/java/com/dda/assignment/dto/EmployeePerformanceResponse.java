package com.dda.assignment.dto;

import java.util.List;

public class EmployeePerformanceResponse {
	
	private Long employeeId;
	private String employeeName;
	private String designation;
	private List<EmployeePerformance> employeePerformances;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
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
	public List<EmployeePerformance> getEmployeePerformances() {
		return employeePerformances;
	}
	public void setEmployeePerformances(List<EmployeePerformance> employeePerformances) {
		this.employeePerformances = employeePerformances;
	}
	

}
