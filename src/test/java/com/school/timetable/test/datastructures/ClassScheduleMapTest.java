package com.school.timetable.test.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.school.timetable.datastructures.ClassScheduleMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.ClassInfo;
import com.school.timetable.domain.entities.Timetable.ScheduleEntry;

public class ClassScheduleMapTest {

    @Test
    public void testAddAndRetrieveSchedule() {
    	
        ClassScheduleMap map = new ClassScheduleMap();
        ClassInfo classInfo = new ClassInfo("10", "A", "Mathematics");
        ScheduleEntry entry = new ScheduleEntry(1, classInfo);

        map.addSchedule("10A", DayOfWeek.Monday, entry);

        List<ScheduleEntry> schedule = map.getSchedule("10A", DayOfWeek.Monday);

        // Assertions
        assertNotNull(schedule, "Schedule should not be null");
        assertEquals(1, schedule.size(), "Schedule size should be 1");
        assertEquals("Mathematics", schedule.get(0).getClassInfo().getSubject(), "Subject should match");
    }
}
