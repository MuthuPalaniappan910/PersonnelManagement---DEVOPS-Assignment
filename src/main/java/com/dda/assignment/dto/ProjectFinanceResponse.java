package com.dda.assignment.dto;

import java.util.List;

public class ProjectFinanceResponse {
	
	private Long projectId;
	private String projectName;
	private List<ProjectFinance> finance;
	
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
	public List<ProjectFinance> getFinance() {
		return finance;
	}
	public void setFinance(List<ProjectFinance> finance) {
		this.finance = finance;
	}

}
