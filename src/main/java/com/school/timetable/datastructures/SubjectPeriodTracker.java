package com.school.timetable.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubjectPeriodTracker {
	private final Map<String, Map<String, PeriodRequirement>> tracker = new HashMap<>();
	private final Set<String> completedSubjects = new HashSet<>();
	private final Set<String> incompleteSubjects = new HashSet<>();

	public void addPeriodRequirement(String subject, String classKey, PeriodRequirement requirement) {
		tracker.putIfAbsent(subject, new HashMap<>());
		tracker.get(subject).put(classKey, requirement);
		incompleteSubjects.add(subject);
	}

	public boolean isSubjectComplete(String subject) {
		return completedSubjects.contains(subject);
	}

	public PeriodRequirement getPeriodRequirement(String subject, String classKey) {
		return tracker.get(subject).get(classKey);
	}

	// Getter for internal map (if needed)
	public Map<String, Map<String, PeriodRequirement>> getTracker() {
		return tracker;
	}
}
