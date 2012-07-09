package smartcampus.service.esse3.test;

import java.util.List;

import junit.framework.TestCase;
import smartcampus.service.esse3.data.message.Esse3.AdLog;
import smartcampus.service.esse3.data.message.Esse3.Exam;
import smartcampus.service.esse3.data.message.Esse3.ExamDescription;
import smartcampus.service.esse3.data.message.Esse3.ExamTeacher;
import smartcampus.service.esse3.data.message.Esse3.StudentExams;
import smartcampus.service.esse3.script.Esse3WSScript;

public class Test extends TestCase {

	public void test() throws Exception {
		
//		System.out.println(Esse3WSScript.getStudent("ZMBSCR83L08H330I"));
//		System.exit(0);
//		System.out.println(Esse3WSScript.getExams("ZMBSCR83L08H330I"));
		List<AdLog> logs = Esse3WSScript.getAdLogs("2005");
//		System.out.println(logs);
//		System.exit(0);
		StudentExams exams = Esse3WSScript.getExams("ZMBSCR83L08H330I");

		for (Exam exam: exams.getExamsList()) {
			ExamDescription descr = Esse3WSScript.getExamDescription(exam.getCod(), "2005", logs);
			ExamTeacher teach = Esse3WSScript.getExamTeacher(exam.getCod(), "2005", logs);
			System.out.println(exam.getCod());
			System.out.println(teach);
			System.out.println(descr);
			System.out.println("----------------------");
			
//			ExamDescription descr = Esse3WSScript.getExamDescription(exam.getCod(), "2005", logs);
//			System.out.println("[" + descr + "]");
		}
		

		
		
	}
	
}
