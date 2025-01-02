package com.school.timetable.test.populator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.school.timetable.datastructures.ClassScheduleMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.common.SchoolConfiguration;
import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.domain.entities.ClassInfo;
import com.school.timetable.domain.entities.Teacher;
import com.school.timetable.populator.ClassSchedulePopulator;

public class ClassSchedulePopulatorTest {

    @Test
    public void testPopulateWithClassTeacherOf() {
        ClassScheduleMap map = new ClassScheduleMap();
        ClassSchedulePopulator populator = new ClassSchedulePopulator();

        // Mock input
        Teacher teacher = new Teacher(
                "Naga",
                null,
                null,
                null,
                null,
                2,
                1,
                5,
                new ClassInfo("10", "A", "Mathematics")
        );
        SchoolConfiguration schoolConfig = new SchoolConfiguration(8); // Assuming total periods per day is 8
        List<Teacher> teachers = List.of(teacher);    
        TimetableInput input = new TimetableInput(schoolConfig, teachers, null);
        // Act
        populator.populate(input, map);
        // Assert
        assertNotNull(map.getScheduleMap(), "Class schedule map should not be null");
        assertEquals(1, map.getSchedule("10A", DayOfWeek.Monday).size(), "ClassTeacherOf should be assigned the first period");
    }
}
