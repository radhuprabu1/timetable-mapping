package com.school.timetable.domain.entities;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.school.timetable.domain.common.DayOfWeek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a teacher’s timetable,
 * 	with the schedule mapped by day and periods.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected fields
public class Timetable {

	private String teacherName; // Could be a Teacher name
	private Map<DayOfWeek, List<ScheduleEntry>> schedule;
	private int totalPeriodsPerWeek;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ScheduleEntry {

		/** The period number within the day. */
		private int period;
		
    /** The class information associated with this schedule entry. */
		private ClassInfo classInfo;
		
		@Override
		public String toString() {
		    return "ScheduleEntry(period=" + period +
		           ", classInfo=" + classInfo + ")";
		}


	}

}
