package com.school.timetable.datastructures;

import com.school.timetable.domain.common.DayOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tracks schedules for each subject by day and associated class-sections.
 */
public class SubjectScheduleMap {

    // Map of subject name -> Day of the week -> List of class-sections
    private final Map<String, Map<DayOfWeek, List<String>>> scheduleMap = new HashMap<>();

    /**
     * Adds a class-section to the subject's schedule for a specific day.
     *
     * @param subjectName  The subject's name.
     * @param day          The day of the week.
     * @param classSection The class-section (e.g., "10A").
     */
    public void addClassSection(String subjectName, DayOfWeek day, String classSection) {
        scheduleMap.putIfAbsent(subjectName, new HashMap<>());
        scheduleMap.get(subjectName).putIfAbsent(day, new ArrayList<>());
        scheduleMap.get(subjectName).get(day).add(classSection);
    }

    /**
     * Retrieves the schedule for a specific subject on a specific day.
     *
     * @param subjectName The subject's name.
     * @param day         The day of the week.
     * @return A list of class-sections for the specified day.
     */
    public List<String> getScheduleForDay(String subjectName, DayOfWeek day) {
        return scheduleMap.getOrDefault(subjectName, Map.of())
                          .getOrDefault(day, List.of());
    }

    /**
     * Checks if a subject exceeds the maximum allowed periods per week.
     *
     * @param subjectName       The subject's name.
     * @param maxPeriodsPerWeek The maximum allowed periods per week.
     * @return True if the subject exceeds the limit, false otherwise.
     */
    public boolean exceedsMaxPeriodsPerWeek(String subjectName, int maxPeriodsPerWeek) {
        return scheduleMap.getOrDefault(subjectName, Map.of())
                          .values()
                          .stream()
                          .mapToInt(List::size)
                          .sum() > maxPeriodsPerWeek;
    }
}
