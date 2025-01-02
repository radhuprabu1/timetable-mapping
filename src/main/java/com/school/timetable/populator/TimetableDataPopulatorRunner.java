package com.school.timetable.populator;

import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.parser.JsonInputParser;

public class TimetableDataPopulatorRunner {
    public static void main(String[] args) {
        timetableRunnerWithJson();
    }

	/**
	 * 
	 */
	private static void timetableRunnerWithJson() {
		try {
            // Parse the input JSON file
            JsonInputParser parser = new JsonInputParser();
            TimetableInput input = parser.parseInput("ComboScenario.json");

            // Initialize the orchestrator
            TimetableDataPopulator populator = new TimetableDataPopulator();

            // Populate all data structures
            populator.populateAll(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
