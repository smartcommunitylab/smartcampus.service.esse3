package smartcampus.service.esse3.test;

import it.sayservice.platform.core.bus.common.exception.PersistenceException;
import it.sayservice.platform.core.bus.service.handler.BusServiceHandler;
import it.sayservice.platform.core.bus.service.persistence.PersistenceEngine;
import it.sayservice.platform.core.common.exception.EntityNotFoundException;
import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.servicebus.test.DataFlowTestHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import smartcampus.service.esse3.data.message.Esse3.Student;
import smartcampus.service.esse3.impl.GetStudentDataDataFlow;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestDataFlow extends TestCase {
	public void atestRun() throws PersistenceException, EntityNotFoundException, InvalidProtocolBufferException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "/test-context.xml", "/applicationContext.xml" });
		assertNotNull(context);
		PersistenceEngine persistenceEngine = (PersistenceEngine) context.getBean("busPersistenceEngineDAO");
		assertNotNull(persistenceEngine);

		BusServiceHandler busServiceHandler = (BusServiceHandler) context.getBean("busServiceHandler");
		assertNotNull(busServiceHandler);
		busServiceHandler.start();

		System.out.println("Waiting...");
		Scanner in = new Scanner(System.in);
		in.nextLine();

		Map<String, Object> studentParameters = new HashMap<String, Object>();
		studentParameters.put("fiscalCode", "ZMBSCR83L08H330I");
		// studentParameters.put("fiscalCode", "FSTMRZ68M14H612N");

		Map<String, Object> examParameters = new HashMap<String, Object>();
		examParameters.put("cod", "45314");
		examParameters.put("aaOff", "2005");

		Object object = null;
		try {
			object = busServiceHandler.invokeService("smartcampus.service.esse3", "GetStudentData", studentParameters, null);
			// object = busServiceHandler.invokeService("smartcampus.service.esse3",
			// "GetStudentExams", studentParameters, null);
			// object = busServiceHandler.invokeService("smartcampus.service.esse3",
			// "GetExamDescription", examParameters, null);
			// object = busServiceHandler.invokeService("smartcampus.service.esse3",
			// "GetExamTeacher", examParameters, null);
			// object = busServiceHandler.invokeService("smartcampus.service.esse3",
			// "GetCompleteExam", examParameters, null);
			System.out.println(object);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertTrue(true);

	}

	public void test() throws ServiceException {
		Map<String, Object> studentParameters = new HashMap<String, Object>();
		studentParameters.put("fiscalCode", "ZMBSCR83L08H330I");
		
		DataFlowTestHelper helper = new DataFlowTestHelper();
		Map<String, Object> out = helper.executeDataFlow("smartcampus.service.esse3",  "GetStudentData", new GetStudentDataDataFlow(), studentParameters);
		System.err.println(out);
		
	}
}
