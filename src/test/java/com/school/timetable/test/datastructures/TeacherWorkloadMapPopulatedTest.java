package com.school.timetable.test.datastructures;

import com.school.timetable.datastructures.TeacherWorkloadMap;
import com.school.timetable.domain.common.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherWorkloadMapPopulatedTest {

    @Test
    public void testPopulatedTeacherWorkload() {
        TeacherWorkloadMap map = new TeacherWorkloadMap();

        // Simulate populated data
        map.addWorkload("Naga", DayOfWeek.Monday);

        int workload = map.getWorkload("Naga", DayOfWeek.Monday);

        // Assertions
        assertEquals(1, workload, "Workload should match");
    }
}
