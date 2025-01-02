package com.school.timetable.domain.entities;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.timetable.domain.common.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Represents all details related to a teacher.
 * 	includes their name, subjects they teach,
 * 	forbiddenPeriods, and the classes they teach
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected field
public class Teacher {

	@JsonProperty("teacherName")
	private String name;
	private List<String> subjects;
	private List<ClassInfo> classes;

	private Map<DayOfWeek, List<Integer>> forbiddenPeriods;

	@JsonProperty("availOnly") // Maps "availOnly" in JSON to "availablePeriods"
	private Map<DayOfWeek, List<Integer>> availablePeriods;

	private int maxConsecutivePeriods;
	private int minPeriodsPerDay;
	private int periodsPerWeek;
	private ClassInfo classTeacherOf;

	@Override
	public String toString() {
		return "Teacher(name=" + name +
				", subjects=" + subjects +
				", forbiddenPeriods=" + forbiddenPeriods +
				", availablePeriods=" + availablePeriods +
				", maxConsecutivePeriods=" + maxConsecutivePeriods +
				", minPeriodsPerDay=" + minPeriodsPerDay +
				", periodsPerWeek=" + periodsPerWeek +
				", classTeacherOf=" + classTeacherOf + ")";
	}

}