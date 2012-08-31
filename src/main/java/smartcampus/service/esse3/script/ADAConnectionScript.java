package smartcampus.service.esse3.script;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import smartcampus.service.esse3.data.message.Esse3.Exam;
import smartcampus.service.esse3.data.message.Esse3.Student;
import smartcampus.service.esse3.data.message.Esse3.StudentExams;

public class ADAConnectionScript {

	public Student getStudentData(String json, String idAda) throws JsonParseException, JsonMappingException, IOException {
		Student.Builder builder = Student.newBuilder();
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(json, Map.class);
		
		builder.setNation((String)map.get("nation"));
		builder.setPhone((String)map.get("phone"));
		builder.setMobile((String)map.get("mobile"));
		builder.setAddress((String)map.get("address"));
		builder.setEnrollmentYear((String)map.get("enrollmentYear"));
		builder.setAcademicYear((String)map.get("academicYear"));
		builder.setSupplementaryYears((String)map.get("supplementaryYears"));
		builder.setCfu((String)map.get("cfu"));
		builder.setCfuTotal((String)map.get("cfuTotal"));
		builder.setMarksNumber((String)map.get("marksNumber"));
		builder.setMarksAverage((String)map.get("marksAverage"));
		builder.setCds((String)map.get("cds"));
		
		// fillers : missing
		builder.setFiscalCode("");
		builder.setName("");
		builder.setSurname("");
		builder.setGender("");
		builder.setDateOfBirth("");
		
		builder.setIdAda(idAda);
		
		return builder.build();
	}
	
	public StudentExams getExams(String json, String idAda) throws JsonParseException, JsonMappingException, IOException {
		List<Exam> result = new ArrayList<Exam>();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list = mapper.readValue(json, List.class);
		
		for (Object e: list) {
			Map<String, Object> map = mapper.convertValue(e, Map.class);
			
			Exam.Builder builder = Exam.newBuilder();
			
			System.out.println(map);
			
			builder.setCod(notNull((String)map.get("cod")));
			builder.setDate((Long)map.get("date"));
			builder.setId(notNull((String)map.get("id")));
			builder.setLode((Boolean)map.get("lode"));
			builder.setName(notNull((String)map.get("name")));
			builder.setResult(notNull((String)map.get("result")));
			builder.setWeight(notNull(((Integer)map.get("weight")).toString()));
			
			result.add(builder.build());
		}
		
		StudentExams.Builder builder = StudentExams.newBuilder();
		builder.addAllExams(result);
		builder.setIdAda(idAda);
		
		return builder.build();
	}
	
	private static String notNull(Object s) {
		return (s == null) ? "" : s.toString();
	}
	
}
