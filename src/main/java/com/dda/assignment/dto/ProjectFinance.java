package com.dda.assignment.dto;

import java.time.LocalDate;

public class ProjectFinance {
	
	private Long financeId;
	private Double amountAllocated;
	private Double amountSpent;
	private LocalDate financialYear;
	public Long getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Long financeId) {
		this.financeId = financeId;
	}
	public Double getAmountAllocated() {
		return amountAllocated;
	}
	public void setAmountAllocated(Double amountAllocated) {
		this.amountAllocated = amountAllocated;
	}
	public Double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(Double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public LocalDate getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(LocalDate financialYear) {
		this.financialYear = financialYear;
	}

}
