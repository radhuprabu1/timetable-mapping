package com.school.timetable.test.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.school.timetable.domain.common.TimetableInput;
import com.school.timetable.parser.JsonInputParser;
import com.school.timetable.populator.TimetableDataPopulator;

public class JsonInputParserTest {

	@Test
	public void testParseInput() throws Exception {
		JsonInputParser parser = new JsonInputParser();
		TimetableInput input = parser.parseInput("input.json");
        
		TimetableDataPopulator populator = new TimetableDataPopulator();

        // Populate all data structures
        populator.populateAll(input);
		assertNotNull(input);
		assertEquals(8, input.getSchoolConfiguration().getTotalPeriodsPerDay());
		assertEquals(1, input.getTeachers().size());
		assertEquals("Radhu", input.getTeachers().get(0).getName());
	}
	
/*    @Test
    public void testMockOutputGeneration() {
        MockOutputGenerator generator = new MockOutputGenerator();
        String outputJson = generator.generateMockOutput();

        assertNotNull(outputJson);
        assertTrue(outputJson.contains("timetableSummary"));
        assertTrue(outputJson.contains("Mathematics"));
    }
*/
	@Test
	public void testComboScenarioPopulator() throws Exception {
		JsonInputParser parser = new JsonInputParser();
		TimetableInput input = parser.parseInput("ComboScenario.json");
        
		TimetableDataPopulator populator = new TimetableDataPopulator();

        populator.populateAll(input);
		assertNotNull(input);
		assertEquals(8, input.getSchoolConfiguration().getTotalPeriodsPerDay());
		//assertEquals(1, input.getTeachers().size());
		assertEquals("Radhu", input.getTeachers().get(0).getName());
	}

	@Test
	public void testPopulator() throws Exception {
		JsonInputParser parser = new JsonInputParser();
		TimetableInput input = parser.parseInput("classTeacherOfScenario.json");
        
		TimetableDataPopulator populator = new TimetableDataPopulator();

        populator.populateAll(input);
		assertNotNull(input);
		assertEquals(8, input.getSchoolConfiguration().getTotalPeriodsPerDay());
		//assertEquals(1, input.getTeachers().size());
		assertEquals("Radhu", input.getTeachers().get(0).getName());
	}
	
	@Test
	public void testForbiddenPeriodPopulator() throws Exception {
		JsonInputParser parser = new JsonInputParser();
		TimetableInput input = parser.parseInput("ForbiddenPeriodsScenario.json");
        
		TimetableDataPopulator populator = new TimetableDataPopulator();

        populator.populateAll(input);
		assertNotNull(input);
		assertEquals(8, input.getSchoolConfiguration().getTotalPeriodsPerDay());
		//assertEquals(1, input.getTeachers().size());
		assertEquals("Radhu", input.getTeachers().get(0).getName());
	}
	
}
