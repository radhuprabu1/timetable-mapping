package com.school.timetable.domain.common;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.school.timetable.domain.constraints.SubjectDetails;
import com.school.timetable.domain.entities.Teacher;
import com.school.timetable.parser.SubjectDetailsDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected fields
public class TimetableInput {
	private SchoolConfiguration schoolConfiguration;
	private List<Teacher> teachers;
	
	/*
	 * subjectDetails -> Maps to the subjectDetails object,
	 * where each key is a subject name,
	 * and the value is a list of constraints.
	 *

	/*
	 * // Maps dynamic subjects (e.g., "Mathematics") to SubjectDetails private
	 * Map<String, List<SubjectDetails>> subjectDetails = new HashMap<>();
	 * 
	 * // Dynamically map subject details and inject the subject name
	 * 
	 * @JsonAnySetter public void addSubjectDetails(String subject,
	 * List<SubjectDetails> details) { for (SubjectDetails detail : details) {
	 * detail.setSubject(subject); // Dynamically set the subject field }
	 * this.subjectDetails.put(subject, details); }
	 */
	
	@JsonDeserialize(using = SubjectDetailsDeserializer.class)
    private Map<String, List<SubjectDetails>> subjectDetails;
}
