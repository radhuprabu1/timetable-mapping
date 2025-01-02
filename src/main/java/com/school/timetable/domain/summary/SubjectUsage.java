package com.school.timetable.domain.summary;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected fields
@Builder
public class SubjectUsage {
	private String subjectName;
	private List<ClassPeriodCount> classesTaughtIn;

	/**
    public SubjectUsage(String subjectName, List<ClassPeriodCount> classesTaughtIn) {
        this.subjectName = subjectName;
        this.classesTaughtIn = classesTaughtIn;
    }
	 */
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ClassPeriodCount {

		private String classGrade;
		private String section;
		private int totalPeriods;
		
		@Override
		public String toString() {
		    return "ClassPeriodCount(classGrade=" + classGrade +
		           ", section=" + section +
		           ", totalPeriods=" + totalPeriods + ")";
		}

	}

}
