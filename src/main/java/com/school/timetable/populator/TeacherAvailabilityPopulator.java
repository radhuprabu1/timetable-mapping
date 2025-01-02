package com.school.timetable.populator;

import com.school.timetable.datastructures.TeacherAvailabilityMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.Teacher;
import com.school.timetable.domain.common.TimetableInput;

import java.util.List;
import java.util.Map;

public class TeacherAvailabilityPopulator {

	public void populate(TimetableInput input, TeacherAvailabilityMap availabilityMap) {
		for (Teacher teacher : input.getTeachers()) {
			// If availOnly is defined, use it exclusively
			if (teacher.getAvailablePeriods().size() > 0) {
				for (Map.Entry<DayOfWeek, List<Integer>> entry : teacher.getAvailablePeriods().entrySet()) {
					DayOfWeek day = entry.getKey();
					for (Integer period : entry.getValue()) {
						availabilityMap.addAvailability(day, period, teacher);
					}
				}
				continue; // Skip further processing for this teacher
			}

			// If availOnly is not defined, populate based on forbiddenPeriods
			for (DayOfWeek day : DayOfWeek.values()) {
				for (int period = 1; period <= input.getSchoolConfiguration().getTotalPeriodsPerDay(); period++) {
					boolean isForbidden = teacher.getForbiddenPeriods() != null
							&& teacher.getForbiddenPeriods().getOrDefault(day, List.of()).contains(period);

					if (!isForbidden) {
						availabilityMap.addAvailability(day, period, teacher);
					}
				}
			}
		}
	}
}
