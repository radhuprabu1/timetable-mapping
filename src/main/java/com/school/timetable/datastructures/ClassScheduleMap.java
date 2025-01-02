package com.school.timetable.datastructures;

import com.school.timetable.domain.entities.Timetable.ScheduleEntry;
import com.school.timetable.domain.common.DayOfWeek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Keep track of which subject and teacher 
 * 	are assigned to each class-grade and
 * 	section for each period and day
 */
public class ClassScheduleMap {

	/**
	 * The internal map to store class schedules.
	 * 
	 * Key: Class grade + section (e.g., "10A")
	 * Value: Map of DayOfWeek to a list of ScheduleEntry objects.
	 */
	private final Map<String, Map<DayOfWeek, List<ScheduleEntry>>> scheduleMap;

	/**
	 * Constructs a new ClassScheduleMap with an empty internal map.
	 */
	public ClassScheduleMap() {
		this.scheduleMap = new HashMap<>();
	}

	/**
	 * Adds a schedule entry for a given class and day.
	 *
	 * @param classGrade The class grade (e.g., "10").
	 * @param day The day of the week.
	 * @param entry The ScheduleEntry object to be added.
	 */
	public void addSchedule(String classGrade, DayOfWeek day, ScheduleEntry entry) {
		scheduleMap.putIfAbsent(classGrade, new HashMap<>());
		scheduleMap.get(classGrade).putIfAbsent(day, new java.util.ArrayList<>());
		scheduleMap.get(classGrade).get(day).add(entry);
	}


	public List<ScheduleEntry> getSchedule(String classGrade, DayOfWeek day) {
		return scheduleMap.getOrDefault(classGrade, new HashMap<>()).getOrDefault(day, List.of());
	}

	/**
	 * Gets the internal schedule map.
	 * 
	 * @return The internal map containing the class schedules.
	 */
	public Map<String, Map<DayOfWeek, List<ScheduleEntry>>> getScheduleMap() {
		return scheduleMap;
	}
}
