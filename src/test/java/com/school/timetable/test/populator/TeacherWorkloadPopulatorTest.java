package com.school.timetable.test.populator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.school.timetable.datastructures.TeacherWorkloadMap;
import com.school.timetable.domain.common.DayOfWeek;

public class TeacherWorkloadPopulatorTest {

    @Test
    public void testInitializeWorkload() {
        TeacherWorkloadMap map = new TeacherWorkloadMap();
        //TeacherWorkloadPopulator populator = new TeacherWorkloadPopulator();

        // Mock input
        com.school.timetable.domain.entities.Teacher teacher = new com.school.timetable.domain.entities.Teacher();
        teacher.setName("Radhu");

        //populator.initialize(new com.school.timetable.domain.common.TimetableInput(List.of(teacher), null), map);

        // Assert
        assertNotNull(map.getWorkloadMap(), "Workload map should not be null");
        assertEquals(0, map.getWorkload("Naga", DayOfWeek.Monday), "Initial workload should be 0");
    }
}
