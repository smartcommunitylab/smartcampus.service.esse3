package smartcampus.service.esse3.script;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import smartcampus.service.esse3.data.message.Esse3.ADCalendarTable;
import smartcampus.service.esse3.data.message.Esse3.CalendarCds;
import smartcampus.service.esse3.data.message.Esse3.Luogo;
import bsh.ParseException;

import com.google.protobuf.Message;

public class WebCalendarScript {
	
	public List<String> getCalendarURLs(String json) throws Exception {
		List<String> result = new ArrayList<String>();
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> data = (Map<String, Object>)mapper.readValue(json, Map.class);
		List<Map<String, Object>> activities = (List<Map<String, Object>>)data.get("Attivita");
		
		for (Map<String, Object> activity: activities) {
			String id = activity.get("IdADfisica").toString();
			String url = getDetailURL(id);
			result.add(url);
		}
		
		return result;
	}
	
	public List<Message> getCalendarAD(String json) throws Exception {
		List<Message> result = new ArrayList<Message>();
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> data = (Map<String, Object>)mapper.readValue(json, Map.class);
		List<Map<String, Object>> events = (List<Map<String, Object>>)data.get("Eventi");
		
		for (Map<String, Object> event: events) {
			CalendarCds.Builder builder = CalendarCds.newBuilder();
			builder.setId((String)event.get("id"));
			builder.setFrom(Long.parseLong((String)event.get("start")) * 1000);
			builder.setTo(Long.parseLong((String)event.get("end")) * 1000);
		 String title[] = ((String)event.get("title")).split("\n");

		 if (title.length == 4) {
		 builder.setTitle(title[0]);
		 builder.setTeacher(title[1]);
		 builder.setType(title[2].replaceAll("[\\(\\)]", ""));
		 builder.setRoom(title[3].replaceAll("[\\[\\]]", ""));
		 } else if (title.length == 5) {
			 builder.setTitle(title[0] + " " + title[1]);
			 builder.setTeacher(title[2]);
			 builder.setType(title[3].replaceAll("[\\(\\)]", ""));
			 builder.setRoom(title[4].replaceAll("[\\[\\]]", ""));			 
		 } else {
			 throw new ParseException("Error parsing event: " + event.get("title"));
		 }
		 result.add(builder.build());
		}

		return result;
	}
	
	public String getCalendarURL(String cds, String courseYear) {
		String from = getFirstCalendarDay();
		String to = getLastCalendarDay();
		System.err.println(from + " / " + to);
		String result = "http://webapps.unitn.it/Orari/it/Web/AjaxEventi/c/" + cds + "-" + courseYear + "/agendaWeek?start=" + from + "&end=" + to;
		return result;
	}
	
	public String getDetailURL(String id) {
		String from = getFirstCalendarDay();
		String to = getLastCalendarDay();
		String result = "http://webapps.unitn.it/Orari/it/Web/AjaxEventi/det/" + id + "?start=" + from + "&end=" + to;
		return result;
	}	
	
	
	private String getFirstCalendarDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 1);
		cal.set(Calendar.MILLISECOND, 0);
//		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String time = "" + cal.getTimeInMillis(); 
		return time.substring(0, time.length() - 3);
	}
	
	private String getLastCalendarDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
//		cal.set(Calendar.DAY_OF_WEEK, 1);
//		cal.roll(Calendar.DAY_OF_WEEK, 7);
		cal.roll(Calendar.WEEK_OF_YEAR, 2);
		String time = "" + cal.getTimeInMillis(); 
		return time.substring(0, time.length() - 3);
	}	

	/////////////////////
	
	public String getFullCalendarURL(String cds, String year) {
		String from = getFirstYearDay();
		String to = getLastYearDay();
		String result = "http://webapps.unitn.it/Orari/it/Web/AjaxEventi/c/" + cds + "-" + year + "/agendaWeek?start=" + from + "&end=" + to;
		return result;
	}
	
	public List<String> getFullCalendarADIds(String json) throws Exception {
		List<String> result = new ArrayList<String>();
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> data = (Map<String, Object>)mapper.readValue(json, Map.class);
		List<Map<String, Object>> activities = (List<Map<String, Object>>)data.get("Attivita");
		
		for (Map<String, Object> activity: activities) {
			String id = activity.get("IdADfisica").toString();
//			String url = "http://webapps.unitn.it/Orari/it/Web/DettaglioAttivita/" + id;
			result.add(id);
		}
		
		return result;
	}	
	
	public List<Message> buildADCalendar(ADCalendarTable calendarRows, String cdsId) throws Exception {
		List<Message> result = new ArrayList<Message>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		for (int i = 0; i < calendarRows.getDataCount(); i++) {
			CalendarCds.Builder cc = CalendarCds.newBuilder();
//			cc.setRoom(calendarRows.getAula(i) + "\n" + calendarRows.getEdificio(i)); // new String(calendarRows.getEdificio(i).getBytes(), Charset.forName("UTF-8")));
			
			String room = "";
			Luogo luogo =  calendarRows.getLuogo(i);
			for (int j = 0; j < luogo.getAulaCount(); j++) {
					room += luogo.getAula(j) + " " + luogo.getEdificio(j) + ", ";
			}
			room = room.substring(0, room.length() - 2);
			cc.setRoom(room);
			
			String teacher = "";
			for (String t: calendarRows.getDocenti(i).getDocenteList()) {
				teacher += t + ",";
			}
			teacher = teacher.substring(0, teacher.length() - 1);
			
			cc.setTeacher(teacher);
			String descr[] = calendarRows.getDescrizione(i).split("<br/>");
			if (descr.length == 1) {
				cc.setTitle(calendarRows.getDescrizione(i));
			} else {
				cc.setTitle(descr[1].trim() + " " + descr[0].trim());
			}
			cc.setType(calendarRows.getTipologia(i));
			cc.setId(cdsId);
			
			Date d = formatter.parse(calendarRows.getData(i));
			Calendar cal = new GregorianCalendar();
			cal.setTime(d);
			String time[];
			time = calendarRows.getOra(i).replace(" ", "").split("-");

			String hm[] = time[0].split("\\.");
			cal.set(Calendar.HOUR, Integer.parseInt(hm[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
			cc.setFrom(cal.getTimeInMillis());
			
			hm = time[1].split("\\.");
			cal.set(Calendar.HOUR, Integer.parseInt(hm[0]));
			cal.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
			cc.setTo(cal.getTimeInMillis());			
			
			result.add(cc.build());
		}
		
		return result;
	}
	
	private String getFirstYearDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 1);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String time = "" + cal.getTimeInMillis(); 
		return time.substring(0, time.length() - 3);
	}
	
	private String getLastYearDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 1);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		String time = "" + cal.getTimeInMillis(); 
		return time.substring(0, time.length() - 3);
	}	
	
	
}
