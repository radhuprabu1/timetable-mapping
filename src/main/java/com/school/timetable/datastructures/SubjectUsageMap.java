package com.school.timetable.datastructures;

import com.school.timetable.domain.summary.SubjectUsage.ClassPeriodCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Track which classes and sections are taught 
 * 	for each subject, for use in output generation
 */
public class SubjectUsageMap {
	private final Map<String, 
		List<ClassPeriodCount>> usageMap;

	public SubjectUsageMap() {
		this.usageMap = new HashMap<>();
	}

	// Add usage details for a subject
	public void addUsage(String subject, ClassPeriodCount count) {
		usageMap.putIfAbsent(subject, new java.util.ArrayList<>());
		usageMap.get(subject).add(count);
	}

	// Get usage details for a subject
	public List<ClassPeriodCount> getUsage(String subject) {
		return usageMap.getOrDefault(subject, List.of());
	}

	// Getter for internal map (if needed)
	public Map<String, List<ClassPeriodCount>> getUsageMap() {
		return usageMap;
	}
}
