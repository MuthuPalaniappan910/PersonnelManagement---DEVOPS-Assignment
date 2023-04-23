package com.dda.assignment.dto;

import java.time.LocalDate;

public class EmployeePerformance {
	
	private Long performanceId;
	private LocalDate performanceYear;
	private String rating;
	
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
