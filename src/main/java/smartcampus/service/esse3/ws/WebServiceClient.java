package smartcampus.service.esse3.ws;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class WebServiceClient {

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
//	private String message;

	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
	
	public String fn_dologin(String username, String password) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		String loginMsg = "<fn_dologin><username>" + username + "</username><password>" + password + "</password></fn_dologin>";
		return serviceResult(loginMsg, "//fn_dologinResponse");
	}
	
	public String fn_retrieve_xml(String sid, String cmd, String pars) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		String cdsMsg = "<fn_retrieve_xml><sid>" + sid +"</sid><retrieve>" + cmd + "</retrieve><params>" + pars + "</params></fn_retrieve_xml>";
		return serviceResult(cdsMsg, "//xml");
	}
	
	public void fn_dologout(String sid) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		String cdsMsg = "<fn_dologout><sid>" + sid +"</sid></fn_dologout>";
		serviceResult(cdsMsg, null);
	}
	

	public String serviceResult(String msg, String xp) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		StreamSource source = new StreamSource(new StringReader(msg));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamResult result = new StreamResult(baos);
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(bais);

		if (xp != null) {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile(xp);

		String res = (String) expr.evaluate(doc, XPathConstants.STRING);

		return res;
		} else {
			return null;
		}
	}

//	public void simpleSendAndReceive() {
//		StreamSource source = new StreamSource(new StringReader(message));
//		StreamResult result = new StreamResult(System.out);
//		webServiceTemplate.sendSourceAndReceiveToResult(source, result);
//	}
	
	public void testSendAndReceive(String msg) {
		StreamSource source = new StreamSource(new StringReader(msg));
		StreamResult result = new StreamResult(System.out);
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);
	}

}