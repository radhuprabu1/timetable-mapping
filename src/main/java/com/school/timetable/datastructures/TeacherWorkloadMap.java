package com.school.timetable.datastructures;

import com.school.timetable.domain.common.DayOfWeek;

import java.util.HashMap;
import java.util.Map;
/**
 * Track how many periods each teacher is 
 * assigned per day and week, 
 * ensuring they do not exceed 
 * maxConsecutivePeriods or periodsPerWeek
 */
public class TeacherWorkloadMap {
	private final Map<String, Map<DayOfWeek, Integer>> workloadMap;

	public TeacherWorkloadMap() {
		this.workloadMap = new HashMap<>();
	}

	public void initializeWorkload(String teacherName, DayOfWeek day) {
	    workloadMap.putIfAbsent(teacherName, new HashMap<>());
	    workloadMap.get(teacherName).put(day, 0); // Set initial workload as 0
	}

	// Add workload for a teacher
	public void addWorkload(String teacherName, DayOfWeek day) {
	    workloadMap.putIfAbsent(teacherName, new HashMap<>());
	    workloadMap.get(teacherName).put(day, workloadMap.get(teacherName).getOrDefault(day, 0) + 1);
	}


	// Get workload for a teacher on a specific day
	public int getWorkload(String teacherName, DayOfWeek day) {
		return workloadMap.getOrDefault(teacherName, new HashMap<>()).getOrDefault(day, 0);
	}

	// Getter for internal map (if needed)
	public Map<String, Map<DayOfWeek, Integer>> getWorkloadMap() {
		return workloadMap;
	}
}
