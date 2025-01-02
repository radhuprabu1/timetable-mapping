package com.school.timetable.populator;

import com.school.timetable.datastructures.TeacherWorkloadMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.Teacher;
import com.school.timetable.domain.common.TimetableInput;

public class TeacherWorkloadPopulator {

	public void initialize(TimetableInput input, TeacherWorkloadMap workloadMap) {
		for (Teacher teacher : input.getTeachers()) {
			for (DayOfWeek day : DayOfWeek.values()) {
				workloadMap.initializeWorkload(teacher.getName(), day); // Initialize workload to 0
			}
		}
	}

	public void updateWorkload(String teacherName, DayOfWeek day, TeacherWorkloadMap workloadMap) {
		workloadMap.addWorkload(teacherName, day); // Increment workload as subjects are assigned
	}

}
