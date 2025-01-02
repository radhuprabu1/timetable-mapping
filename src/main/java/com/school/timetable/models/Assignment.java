package com.school.timetable.models;

import com.school.timetable.domain.entities.Teacher;

/**
 * Represents an assignment of a teacher and subject to a timetable slot.
 */
public class Assignment {
    private Slot slot;
    private Teacher teacher;
    private String subject;

    /**
     * Constructs an Assignment object.
     *
     * @param slot    The timetable slot.
     * @param teacher The teacher assigned to the slot.
     * @param subject The subject assigned to the slot.
     */
    public Assignment(Slot slot, Teacher teacher, String subject) {
        this.slot = slot;
        this.teacher = teacher;
        this.subject = subject;
    }

    // Getters and Setters
    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("Assignment[Slot=%s, Teacher=%s, Subject=%s]", slot, teacher.getName(), subject);
    }
}
