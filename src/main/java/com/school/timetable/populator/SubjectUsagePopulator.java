package com.school.timetable.populator;

import java.util.List;
import java.util.Map;

import com.school.timetable.datastructures.SubjectUsageMap;
import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.domain.constraints.SubjectDetails;
import com.school.timetable.domain.summary.SubjectUsage.ClassPeriodCount;

public class SubjectUsagePopulator {

    public void populate(TimetableInput input, SubjectUsageMap usageMap) {
        for (Map.Entry<String, List<SubjectDetails>> entry : input.getSubjectDetails().entrySet()) {
            String subject = entry.getKey();
            for (SubjectDetails detail : entry.getValue()) {
                usageMap.addUsage(subject, new ClassPeriodCount(detail.getClassGrade(), detail.getSection(), 0));
            }
        }
    }
}
