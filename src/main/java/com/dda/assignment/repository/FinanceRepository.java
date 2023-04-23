package com.dda.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Finance;
import com.dda.assignment.model.Project;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {

	List<Finance> findAllByProject(Project projectDetails);

}
