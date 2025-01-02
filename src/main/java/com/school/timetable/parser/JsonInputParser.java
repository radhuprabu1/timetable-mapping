package com.school.timetable.parser;

/*
 * 	Read the input JSON string (or file).
	Convert it into a TimetableInput object,
TimetableInput - aggregates all the data structures that have been created.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.timetable.domain.common.TimetableInput;

import java.io.IOException;
import java.io.InputStream;

public class JsonInputParser {
	private final ObjectMapper objectMapper;

	public JsonInputParser() {
		this.objectMapper = new ObjectMapper();
	}
	/*
	 * 	ObjectMapper: Jackson class for json parsing.
		readValue: Converts JSON into the specified Java object [TimetableInput.class]
		File: Represents the JSON file provided by the user.
	 */

	// Method to parse JSON from a file
	public TimetableInput parseInput(String resourcePath) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
		if (inputStream == null) {
			throw new IOException("File not found in classpath: " + resourcePath);
		}
		return objectMapper.readValue(inputStream, TimetableInput.class);
	}
}

