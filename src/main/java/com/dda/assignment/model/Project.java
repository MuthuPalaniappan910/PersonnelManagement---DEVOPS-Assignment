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
@Table (name = "Project")
public class Project {
	
	@Id
	@Column(name = "ProjectId")
	@SequenceGenerator(name = "projectSeqGen", sequenceName = "projectSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "projectSeqGen")
	private Long projectId;
	
	@Column(name = "ProjectName")
	private String projectName;
	
	@OneToOne
	@JoinColumn(name = "LocationId")
	private Location location;

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


}
