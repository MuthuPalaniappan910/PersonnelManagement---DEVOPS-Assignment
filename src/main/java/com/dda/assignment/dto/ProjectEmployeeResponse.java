package com.dda.assignment.dto;

import java.util.List;

public class ProjectEmployeeResponse {
	
	private Long projectId;
	private String projectName;
	private List<ProjectEmployee> projectEmployee;
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<ProjectEmployee> getProjectEmployee() {
		return projectEmployee;
	}
	public void setProjectEmployee(List<ProjectEmployee> projectEmployee) {
		this.projectEmployee = projectEmployee;
	}
}
