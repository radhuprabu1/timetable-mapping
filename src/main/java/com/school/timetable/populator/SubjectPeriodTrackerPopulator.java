package com.school.timetable.populator;

import java.util.List;
import java.util.Map;

import com.school.timetable.datastructures.PeriodRequirement;
import com.school.timetable.datastructures.SubjectPeriodTracker;
import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.domain.constraints.SubjectDetails;

public class SubjectPeriodTrackerPopulator {

	public void populate(TimetableInput input, SubjectPeriodTracker tracker) {
		for (Map.Entry<String, List<SubjectDetails>> entry : input.getSubjectDetails().entrySet()) {
			String subject = entry.getKey();
			for (SubjectDetails detail : entry.getValue()) {
				String classKey = detail.getClassGrade();
				//for (classKey : detail.getClassGrade()) {
				 classKey = detail.getClassGrade() + detail.getSection(); // Combine classGrade and section
				tracker.addPeriodRequirement(
						subject,
						classKey,
						new PeriodRequirement(detail.getMinPeriodsPerDay(), detail.getPeriodsPerWeek())
						);//}
			}
		}
	}

}
