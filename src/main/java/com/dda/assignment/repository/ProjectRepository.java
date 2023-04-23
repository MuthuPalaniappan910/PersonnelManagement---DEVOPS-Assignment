package com.dda.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Project> {

	Project findByProjectId(Long projectId);
	
}
