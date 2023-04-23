package com.dda.assignment.model;

import java.time.LocalDate;

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
@Table (name = "Performance")
public class Performance {
	
	@Id
	@Column(name = "PerformanceId")
	@SequenceGenerator(name = "performanceSeqGen", sequenceName = "performanceSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "performanceSeqGen")
	private Long performanceId;
	
	@Column(name = "PerformanceYear")
	private LocalDate performanceYear;
	
	@OneToOne
	@JoinColumn(name = "EmployeeId")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "RatingId")
	private Rating rating;

	public Long getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Long performanceId) {
		this.performanceId = performanceId;
	}

	public LocalDate getPerformanceYear() {
		return performanceYear;
	}

	public void setPerformanceYear(LocalDate performanceYear) {
		this.performanceYear = performanceYear;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
