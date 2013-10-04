/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package smartcampus.service.esse3.script;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		Map<String, Object> map;
		if (json== null || json.length() == 0) {
			map = new TreeMap<String, Object>();
		} else {
			map = mapper.readValue(json, Map.class);
		}
		
		builder.setNation(notNull((String)map.get("nation")));
		builder.setPhone(notNull((String)map.get("phone")));
		builder.setMobile(notNull((String)map.get("mobile")));
		builder.setAddress(notNull((String)map.get("address")));
		builder.setEnrollmentYear(notNull((String)map.get("enrollmentYear")));
		builder.setAcademicYear(notNull((String)map.get("academicYear")));
		builder.setSupplementaryYears(notNull((String)map.get("supplementaryYears")));
		builder.setCfu(notNull((String)map.get("cfu")));
		builder.setCfuTotal(notNull((String)map.get("cfuTotal")));
		builder.setMarksNumber(notNull((String)map.get("marksNumber")));
		builder.setMarksAverage(notNull((String)map.get("marksAverage")));
		builder.setCds(notNull((String)map.get("cds")));
		
		builder.setFiscalCode(notNull((String)map.get("fiscalCode")));
		builder.setName(notNull((String)map.get("name")));
		builder.setSurname(notNull((String)map.get("surname")));
		builder.setGender(notNull((String)map.get("gender")));
		builder.setDateOfBirth(notNull((String)map.get("dateOfBirth")));
		builder.setIdGiada(notNull((String)map.get("idGiada")));
		
		builder.setIdAda(idAda);
		
		return builder.build();
	}
	
	public StudentExams getExams(String json, String idAda) throws JsonParseException, JsonMappingException, IOException {
		List<Exam> result = new ArrayList<Exam>();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list;
		if (json== null || json.length() == 0) {
			list = new ArrayList<Object>();
		} else {
			list = mapper.readValue(json, List.class);
		}
		
		for (Object e: list) {
			Map<String, Object> map = mapper.convertValue(e, Map.class);
			
			Exam.Builder builder = Exam.newBuilder();
			
			System.out.println(map);
			
			builder.setCod(notNull((String)map.get("cod")));
			if (map.containsKey("date")) {
				builder.setDate((Long)map.get("date"));
			} else {
				builder.setDate(Long.MIN_VALUE);
			}
			builder.setId(notNull((String)map.get("id")));
			if (map.containsKey("lode")) {
				builder.setLode((Boolean)map.get("lode"));
			} else {
				builder.setLode(false);
			}
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
