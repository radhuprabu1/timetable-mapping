package com.school.timetable.domain.constraints;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unexpected field
public class SubjectDetails {

	@JsonProperty("class")
	private String classGrade; // Maps to "class" in JSON
	
	private String section; // e.g., "A"
	
    @JsonIgnore // This field won't be serialized/deserialized directly from JSON
	private String subject;
    
	private int minPeriodsPerDay; // Minimum periods required daily
	private int periodsPerWeek; // Total periods required weekly
	
	// Method to set the subject dynamically
    @JsonSetter("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
