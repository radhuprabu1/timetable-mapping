package com.school.timetable.test.datastructures;

import com.school.timetable.datastructures.TeacherWorkloadMap;
import com.school.timetable.domain.common.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherWorkloadMapTest {

    @Test
    public void testAddAndRetrieveWorkload() {
        TeacherWorkloadMap map = new TeacherWorkloadMap();

        map.addWorkload("Naga", DayOfWeek.Monday);
        map.addWorkload("Naga", DayOfWeek.Monday);

        int workload = map.getWorkload("Naga", DayOfWeek.Monday);

        // Assertions
        assertEquals(2, workload, "Workload should be 2 for Monday");
    }
}
