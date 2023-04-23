package com.dda.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Employee;
import com.dda.assignment.model.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long>{

	List<Performance> findByEmployee(Employee employee);

}
