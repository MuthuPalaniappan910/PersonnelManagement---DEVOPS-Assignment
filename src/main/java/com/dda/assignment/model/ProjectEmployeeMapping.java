package com.dda.assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table (name = "ProjectEmployeeMapping")
public class ProjectEmployeeMapping {
	
	@Id
	@Column(name = "ProjectEmployeeMappingId")
	@SequenceGenerator(name = "projectEmployeeSeqGen", sequenceName = "projectEmployeeSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "projectEmployeeSeqGen")
	private Long projectEmployeeMappingId;
	
	@OneToOne
	@JoinColumn(name = "EmployeeId")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "ProjectId")
	private Project project;

	public Long getProjectEmployeeMappingId() {
		return projectEmployeeMappingId;
	}

	public void setProjectEmployeeMappingId(Long projectEmployeeMappingId) {
		this.projectEmployeeMappingId = projectEmployeeMappingId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


}
