package com.school.timetable.populator;

import com.school.timetable.datastructures.ClassScheduleMap;
import com.school.timetable.datastructures.SubjectPeriodTracker;
import com.school.timetable.datastructures.SubjectUsageMap;
import com.school.timetable.datastructures.TeacherAvailabilityMap;
import com.school.timetable.datastructures.TeacherWorkloadMap;
import com.school.timetable.domain.common.TimetableInput;


public class TimetableDataPopulator {

	/**
	 * Populates all data structures and initializes refined helpers.
	 * 
	 * @param input The parsed timetable input object.
	 */
	public void populateAll(TimetableInput input) {

		// Initialize data structures
		TeacherAvailabilityMap availabilityMap = new TeacherAvailabilityMap();
		ClassScheduleMap scheduleMap = new ClassScheduleMap();
		SubjectPeriodTracker tracker = new SubjectPeriodTracker();
		TeacherWorkloadMap workloadMap = new TeacherWorkloadMap();
		SubjectUsageMap usageMap = new SubjectUsageMap();

		// Populate data structures
		new TeacherAvailabilityPopulator().populate(input, availabilityMap);
		new ClassSchedulePopulator().populate(input, scheduleMap);
		new SubjectPeriodTrackerPopulator().populate(input, tracker);
		new TeacherWorkloadPopulator().initialize(input, workloadMap);
		new SubjectUsagePopulator().populate(input, usageMap);

		// Log or verify populated data structures
		System.out.println("*****Teacher Availability******: " + availabilityMap.getAvailabilityMap());
		System.out.println("*****Class Schedules: ********" + scheduleMap.getScheduleMap());
		System.out.println("******Subject Period Tracker****" + tracker.getTracker());
		System.out.println("******Teacher WorkLoad Mapping*****" + workloadMap.getWorkloadMap());
		System.out.println("******Subject Usage Map*******" + usageMap.getUsageMap());

	}
}
