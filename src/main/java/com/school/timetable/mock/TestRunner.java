/**
 * This class will create mocked objects 
 * 	for the Timetable and SubjectUsage 
 * 	and serialize them into a JSON file.
 */

package com.school.timetable.mock;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.timetable.domain.common.DayOfWeek;
import com.school.timetable.domain.entities.ClassInfo;
import com.school.timetable.domain.entities.Timetable;
import com.school.timetable.domain.summary.SubjectUsage;
import com.school.timetable.populator.TimetableDataPopulator;

import lombok.Data;

@Data
public class TestRunner {

	public static void main(String[] args) {
		mockTimetableOutput();
		new TimetableDataPopulator().populateAll(null);
	}

	/**
	 * 
	 */
	private static void mockTimetableOutput() {
		try {
			// Create ObjectMapper for JSON serialization
			ObjectMapper objectMapper = new ObjectMapper();

			// Mock Timetable Object
			Timetable timetable = new Timetable();
			timetable.setTeacherName("Naga");
			timetable.setTotalPeriodsPerWeek(15);
			ClassInfo MondayClassInfo = new ClassInfo("10", "A", "Mathematics");
			ClassInfo TuesdayClassInfo = new ClassInfo("9", "C", "Mathematics");
			timetable.setSchedule(new LinkedHashMap<>(Map.of(
					DayOfWeek.Monday, List.of(
							new Timetable.ScheduleEntry(1, MondayClassInfo),
							new Timetable.ScheduleEntry(2, MondayClassInfo)
							),
					DayOfWeek.Tuesday, List.of(
							new Timetable.ScheduleEntry(1, TuesdayClassInfo),
							new Timetable.ScheduleEntry(3, TuesdayClassInfo)
							)
					)));

			// Mock SubjectUsage Objects
			SubjectUsage mathUsage = new SubjectUsage();
			mathUsage.setSubjectName("Mathematics");
			mathUsage.setClassesTaughtIn(List.of(
					new SubjectUsage.ClassPeriodCount("10", "A", 5),
					new SubjectUsage.ClassPeriodCount("10", "B", 5)
					));

			SubjectUsage physicsUsage = new SubjectUsage();
			physicsUsage.setSubjectName("Physics");
			physicsUsage.setClassesTaughtIn(List.of(
					new SubjectUsage.ClassPeriodCount("11", "A", 3)
					));

			// Combine into Final Output Structure
			Map<String, Object> output = Map.of(
					"timetables", List.of(timetable),
					"timetableSummary", Map.of(
							"subjectsUsage", List.of(mathUsage, physicsUsage)
							)
					);

			// Serialize to JSON and Write to File
			File outputFile = new File("output.json");
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, output);

			System.out.println("Mocked output JSON generated successfully: " + outputFile.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
