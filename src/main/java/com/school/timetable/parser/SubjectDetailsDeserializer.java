package com.school.timetable.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.school.timetable.domain.constraints.SubjectDetails;

public class SubjectDetailsDeserializer extends StdDeserializer<Map<String, List<SubjectDetails>>> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8011566612850951344L;

	public SubjectDetailsDeserializer() {
        this(null);
    }

    public SubjectDetailsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Map<String, List<SubjectDetails>> deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        Map<String, List<SubjectDetails>> subjectDetailsMap = new HashMap<>();
        JsonNode rootNode = parser.getCodec().readTree(parser);

        Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String subjectName = field.getKey(); // The key, e.g., "Mathematics"

            List<SubjectDetails> detailsList = new ArrayList<>();
            for (JsonNode detailNode : field.getValue()) {
                SubjectDetails detail = new SubjectDetails();
                detail.setSubject(subjectName); // Set the subject name
                detail.setClassGrade(detailNode.get("class").asText());
                detail.setSection(detailNode.get("section").asText());
                detail.setMinPeriodsPerDay(detailNode.get("minPeriodsPerDay").asInt());
                detail.setPeriodsPerWeek(detailNode.get("periodsPerWeek").asInt());
                detailsList.add(detail);
            }
            subjectDetailsMap.put(subjectName, detailsList);
        }
        return subjectDetailsMap;
    }
}
