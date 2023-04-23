package com.dda.assignment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table (name = "Rating")
public class Rating {
	
	@Id
	@Column(name = "RatingId")
	@SequenceGenerator(name = "ratingSeqGen", sequenceName = "ratingSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "ratingSeqGen")
	private Long ratingId;
	
	@Column(name = "PerformanceRating")
	private String performanceRating;

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(String performanceRating) {
		this.performanceRating = performanceRating;
	}

}
