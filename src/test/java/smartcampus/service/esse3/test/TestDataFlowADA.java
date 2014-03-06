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
package smartcampus.service.esse3.test;

import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.servicebus.test.DataFlowTestHelper;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import smartcampus.service.esse3.data.message.Esse3.Ad;
import smartcampus.service.esse3.data.message.Esse3.Cds;
import smartcampus.service.esse3.data.message.Esse3.Facolta;
import smartcampus.service.esse3.data.message.Esse3.Pds;
import smartcampus.service.esse3.impl.GetAdDataFlow;
import smartcampus.service.esse3.impl.GetCalendarioCdsDataFlow;
import smartcampus.service.esse3.impl.GetCdsDataFlow;
import smartcampus.service.esse3.impl.GetFacoltaDataFlow;
import smartcampus.service.esse3.impl.GetOrariAdDataFlow;
import smartcampus.service.esse3.impl.GetPdsDataFlow;
import smartcampus.service.esse3.impl.GetStudentDataDataFlow;
import smartcampus.service.esse3.script.Esse3Script;

import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;

public class TestDataFlowADA extends TestCase {

	public void test() throws Exception {
//		Esse3Script s = new Esse3Script();
//		System.out.println(s.getCalendarURL("10114", "1"));
		
		DataFlowTestHelper helper = new DataFlowTestHelper();
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("cdsId", "10114");
//		params.put("cdsId", "10153");
		params.put("cdsId", "10127");
		params.put("anno", "1");
		Map<String, Object> out = helper.executeDataFlow("smartcampus.service.esse3", "GetCalendarioCds", new GetCalendarioCdsDataFlow(), params);
		List<Message> data = (List<Message>) out.get("data");	
		System.out.println(data);		
		
	}
	
	public void _test() throws Exception {
			DataFlowTestHelper helper = new DataFlowTestHelper();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("idAda", "PER121706");
			Map<String, Object> out = helper.executeDataFlow("smartcampus.service.esse3", "GetStudentData", new GetStudentDataDataFlow(), params);
			List<Message> data = (List<Message>) out.get("data");	
			System.out.println(data);
		}
	
	public void _testRun() throws Exception {
		try {
			DataFlowTestHelper helper = new DataFlowTestHelper();
			Map<String, Object> params = new HashMap<String, Object>();
			// params.put("cdsId", "10114");
			// params.put("aaOrd", "2008");
			// params.put("aaOff", "2013");
			Map<String, Object> out = helper.executeDataFlow("smartcampus.service.esse3", "GetFacolta", new GetFacoltaDataFlow(), params);
			List<Message> data = (List<Message>) out.get("data");

			// System.out.println(data); System.exit(0);
			Facolta facolta = (Facolta) data.get(0);
			// for (Message msg1 : data) {
			// Facolta fac = (Facolta) msg1;
			// if ("Informatica e telecomunicazioni".equals(fac.getDescription())) {
			// facolta = fac;
			// }
			// }
			
//			StringBuffer sb = new StringBuffer();
//			sb.append("[");
//			Iterator<Message> it = data.iterator();
//			while (it.hasNext()) {
//				JsonFormat.print(it.next(), sb);
//				if (it.hasNext()) {
//					sb.append(",");
//				} else {
//					sb.append("]");
//				}
//			}
//			System.out.println(new String(sb.toString().getBytes(), Charset.forName("UTF-8")));
//			System.exit(0);
			
			System.out.println(facolta);
			System.out.println("--------------");
			

			params.put("facId", facolta.getFacId());
			out = helper.executeDataFlow("smartcampus.service.esse3", "GetCds", new GetCdsDataFlow(), params);
			data = (List<Message>) out.get("data");
			 System.out.println(data);
			Cds cds = (Cds) data.get(0);
			;
			// for (Message msg2 : data) {
			// Cds c = (Cds) msg2;
			// if (c.getFacId().equals(facolta.getFacId())) {
			// cds = c;
			// break;
			// } else {
			// System.err.println("ERR");
			// }
			// }

//			System.out.println(cds);
			System.out.println("--------------");
			System.exit(0);

			params = new HashMap<String, Object>();
			params.put("cdsId", cds.getCdsId());
			params.put("aaOrd", cds.getAaOrd());
			out = helper.executeDataFlow("smartcampus.service.esse3", "GetPds", new GetPdsDataFlow(), params);
			data = (List<Message>) out.get("data");

			Pds pds = (Pds) data.get(0);

			System.out.println(pds);
			System.out.println("--------------");

			params = new HashMap<String, Object>();
			params.put("cdsId", cds.getCdsId());
			params.put("aaOrd", cds.getAaOrd());
			params.put("aaOff", "2013");
			out = helper.executeDataFlow("smartcampus.service.esse3", "GetAd", new GetAdDataFlow(), params);
			data = (List<Message>) out.get("data");
			Ad ad = (Ad)data.get(0);

			System.out.println(ad);
			System.out.println("--------------");			
			
			params = new HashMap<String, Object>();
			params.put("cdsCod", cds.getCdsCod());
			params.put("aaOrd", cds.getAaOrd());
			params.put("aaOff", "2013");
			params.put("pdsId", pds.getPdsId());
			params.put("pdsCod", pds.getPdsCod());
			params.put("adCod", ad.getAdcod());
			params.put("domCod", ad.getDomPartList().get(0));
			params.put("fatCod", ad.getFatPartList().get(0));
			out = helper.executeDataFlow("smartcampus.service.esse3", "GetOrariAd", new GetOrariAdDataFlow(), params);
			data = (List<Message>) out.get("data");
			System.out.println(data);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
