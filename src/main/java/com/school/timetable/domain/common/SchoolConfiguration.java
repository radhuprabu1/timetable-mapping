package com.school.timetable.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected fields
public class SchoolConfiguration {
	/**
	 * In input json -> "totalPeriodsPerDay": 8

	 *Represents the total number of periods allowed
     	in a single day for the school.

	 */
	private int totalPeriodsPerDay;

	/**
	 * @return the totalPeriodsPerDay
	 */
}
