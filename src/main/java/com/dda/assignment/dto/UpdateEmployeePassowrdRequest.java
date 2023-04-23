package com.dda.assignment.dto;

public class UpdateEmployeePassowrdRequest {
	
	private Long employeeId;
	private String confirmNewPassword;
	private String newPassword;
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}	
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}	

}
