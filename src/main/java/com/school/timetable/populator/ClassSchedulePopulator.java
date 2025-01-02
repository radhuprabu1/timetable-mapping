package com.school.timetable.populator;

import com.school.timetable.datastructures.ClassScheduleMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.domain.entities.ClassInfo;
import com.school.timetable.domain.entities.Teacher;
import com.school.timetable.domain.entities.Timetable.ScheduleEntry;

/**
 * This class populates the ClassScheduleMap with pre-assigned class schedules, 
 * specifically for class teachers who are assigned the first period of each day 
 * for their respective classes.
 */
public class ClassSchedulePopulator {
	
	/**
   * Populates the ClassScheduleMap with pre-assigned class schedules.
   *
   * @param input The TimetableInput object containing teacher and class information.
   * @param scheduleMap The ClassScheduleMap to be populated.
   */
	public void populate(TimetableInput input, ClassScheduleMap scheduleMap) {
	    for (Teacher teacher : input.getTeachers()) {
	        if (teacher.getClassTeacherOf().getClassGrade() != null) {
	            ClassInfo classInfo = teacher.getClassTeacherOf();
	            String classKey = classInfo.getClassGrade() + classInfo.getSection(); // Combine classGrade and section

	            for (DayOfWeek day : DayOfWeek.values()) {
	                ScheduleEntry entry = new ScheduleEntry(1, classInfo); // Assign first period
	                scheduleMap.addSchedule(classKey, day, entry);
	            }
	        }
	    }
	}

}
