package com.school.timetable.test.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.school.timetable.datastructures.TeacherAvailabilityMap;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.Teacher;

public class TeacherAvailabilityMapTest {

    @Test
    public void testAddAndRetrieveAvailability() {
        TeacherAvailabilityMap map = new TeacherAvailabilityMap();
        Teacher teacher = new Teacher("Naga", List.of("Mathematics"), null, null, null, 0, 0, 0, null);

        map.addAvailability(DayOfWeek.Monday, 1, teacher);

        List<Teacher> teachers = map.getAvailableTeachers(DayOfWeek.Monday, 1);

        assertNotNull(teachers);
        assertEquals(1, teachers.size());
        assertEquals("Naga", teachers.get(0).getName());
    }

}
