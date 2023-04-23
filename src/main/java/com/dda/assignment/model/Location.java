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
@Table (name = "Location")
public class Location {
	
	@Id
	@Column(name = "LocationId")
	@SequenceGenerator(name = "locationSeqGen", sequenceName = "locationSeq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "locationSeqGen")
	private Long locationId;
	
	@Column(name = "LocationName")
	private String locationName;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
