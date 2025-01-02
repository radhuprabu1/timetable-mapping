package com.school.timetable.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected fields
public class ClassInfo {
	@JsonProperty("class")
	private String classGrade;  // Maps to "class" in JSON
	private String section;    // e.g., "A"
	private String subject;    // e.g., "Mathematics"


	@Override
	public String toString() {
		return "ClassInfo(classGrade=" + classGrade +
				", section=" + section +
				", subject=" + subject + ")";
	}

}