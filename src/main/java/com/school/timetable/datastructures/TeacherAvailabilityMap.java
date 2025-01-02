package com.school.timetable.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.Teacher;
/*
 * Track when teachers are available, considering 
 * forbiddenPeriods, availOnly, and 
 * maxConsecutivePeriods
 */
public class TeacherAvailabilityMap {
	private final Map<DayOfWeek, Map<Integer, List<Teacher>>> alwaysAvailable = new HashMap<>();
	private final Map<DayOfWeek, Map<Integer, List<Teacher>>> conditionallyAvailable = new HashMap<>();
	private final Map<DayOfWeek, Map<Integer, List<Teacher>>> availabilityMap;

	/*
	 * Stores teachers who are always available 
	 * for all periods (except forbidden).
	 */
	
	public void addAlwaysAvailable(DayOfWeek day, int period, Teacher teacher) {
		alwaysAvailable.putIfAbsent(day, new HashMap<>());
		alwaysAvailable.get(day).putIfAbsent(period, new ArrayList<>());
		alwaysAvailable.get(day).get(period).add(teacher);
	}

	/*
	 * Stores teachers with specific availability constraints
	 */
	public void addConditionallyAvailable(DayOfWeek day, int period, Teacher teacher) {
		conditionallyAvailable.putIfAbsent(day, new HashMap<>());
		conditionallyAvailable.get(day).putIfAbsent(period, new ArrayList<>());
		conditionallyAvailable.get(day).get(period).add(teacher);
	}

	public List<Teacher> getAlwaysAvailable(DayOfWeek day, int period) {
		return alwaysAvailable.getOrDefault(day, Map.of()).getOrDefault(period, List.of());
	}

	public List<Teacher> getConditionallyAvailable(DayOfWeek day, int period) {
		return conditionallyAvailable.getOrDefault(day, Map.of()).getOrDefault(period, List.of());
	}

	public TeacherAvailabilityMap() {
		this.availabilityMap = new HashMap<>();
	}

	// Add availability for a teacher
	public void addAvailability(DayOfWeek day, int period, Teacher teacher) {
		availabilityMap.putIfAbsent(day, new HashMap<>());
		availabilityMap.get(day).putIfAbsent(period, new java.util.ArrayList<>());
		availabilityMap.get(day).get(period).add(teacher);
	}

	// Get available teachers for a specific day and period
	public List<Teacher> getAvailableTeachers(DayOfWeek day, int period) {
		return availabilityMap.getOrDefault(day, new HashMap<>()).getOrDefault(period, List.of());
	}

	// Getter for internal map (if needed)
	public Map<DayOfWeek, Map<Integer, List<Teacher>>> getAvailabilityMap() {
		return availabilityMap;
	}
}
