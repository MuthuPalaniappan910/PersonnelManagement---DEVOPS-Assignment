package com.dda.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Project;
import com.dda.assignment.model.ProjectEmployeeMapping;

@Repository
public interface ProjectEmployeeMappingRepository extends JpaRepository<ProjectEmployeeMapping, Long>{

	List<ProjectEmployeeMapping> findByProject(Project project);

}
