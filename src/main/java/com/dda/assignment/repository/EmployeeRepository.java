package com.dda.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dda.assignment.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeIdAndPassword(Long employeeId, String password);

	Employee findByEmployeeId(Long employeeId);

	@Query(value = "SELECT max(employeeId) from Employee")
	Long getMaxEmployeeId();

}
