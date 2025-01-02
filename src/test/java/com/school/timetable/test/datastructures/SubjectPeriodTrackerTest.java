package com.school.timetable.test.datastructures;

import com.school.timetable.datastructures.SubjectPeriodTracker;
import com.school.timetable.datastructures.PeriodRequirement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectPeriodTrackerTest {

    @Test
    public void testAddAndRetrievePeriodRequirement() {
        SubjectPeriodTracker tracker = new SubjectPeriodTracker();
        PeriodRequirement requirement = new PeriodRequirement(2, 5);

        tracker.addPeriodRequirement("Mathematics", "10A", requirement);

        PeriodRequirement retrieved = tracker.getPeriodRequirement("Mathematics", "10A");

        // Assertions
        assertNotNull(retrieved, "Period requirement should not be null");
        assertEquals(2, retrieved.getRemainingPeriodsPerDay(), "Min periods per day should match");
        assertEquals(5, retrieved.getRemainingPeriodsPerWeek(), "Periods per week should match");

        // Reduce periods and verify
        retrieved.reduceRemainingPeriodsPerDay();
        retrieved.reduceRemainingPeriodsPerWeek();
        assertEquals(1, retrieved.getRemainingPeriodsPerDay(), "Remaining periods per day should reduce");
        assertEquals(4, retrieved.getRemainingPeriodsPerWeek(), "Remaining periods per week should reduce");
    }
}
