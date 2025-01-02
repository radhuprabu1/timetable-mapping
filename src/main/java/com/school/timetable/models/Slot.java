package com.school.timetable.models;

import com.school.timetable.domain.common.DayOfWeek;

/**
 * Represents a single time slot in the timetable.
 */
public class Slot {
    private DayOfWeek day;
    private int period;
    private String classGrade;
    private String section;

    /**
     * Constructs a Slot object.
     *
     * @param day        The day of the week.
     * @param period     The period number.
     * @param classGrade The grade of the class.
     * @param section    The section of the class.
     */
    public Slot(DayOfWeek day, int period, String classGrade, String section) {
        this.day = day;
        this.period = period;
        this.classGrade = classGrade;
        this.section = section;
    }

    // Getters and Setters
    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return String.format("Slot[Day=%s, Period=%d, Class=%s%s]", day, period, classGrade, section);
    }
}
