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
@Table (name = "Finance")
public class Finance {
	
	@Id
	@Column(name = "FinanceId")
	@SequenceGenerator(name = "financeSeqGen", sequenceName = "financeSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "financeSeqGen")
	private Long financeId;
	
	@Column(name = "AmountAllocated")
	private Double amountAllocated;
	
	@Column(name = "AmountSpent")
	private Double amountSpent;
	
	@Column(name = "FinancialYear")
	private LocalDate financialYear;
	
	@OneToOne
	@JoinColumn(name = "ProjectId")
	private Project project;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
