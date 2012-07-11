package smartcampus.service.esse3.script;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import smartcampus.service.esse3.data.message.Esse3.AdLog;
import smartcampus.service.esse3.data.message.Esse3.CompleteExam;
import smartcampus.service.esse3.data.message.Esse3.Exam;
import smartcampus.service.esse3.data.message.Esse3.ExamDescription;
import smartcampus.service.esse3.data.message.Esse3.ExamTeacher;
import smartcampus.service.esse3.data.message.Esse3.Student;
import smartcampus.service.esse3.data.message.Esse3.StudentExams;
import smartcampus.service.esse3.ws.WebServiceClient;

import com.google.protobuf.Message;

public class Esse3WSScript {

	private static WebServiceClient proxy;
	private static CodesUtil codesUtil = new CodesUtil();
	
//	private static Esse3WsServiceLocator service;
//  private static Esse3Ws proxy;

	private static Log log = LogFactory.getLog(Esse3WSScript.class);

	private static void init() {
		if (proxy == null) {
			proxy = new WebServiceClient();
			proxy.setDefaultUri("https://unitn.esse3.pp.cineca.it/services/ESSE3WS");
		}
	}
	
	public static Student getStudent(String fiscalCode) throws Exception {
		String sid = login();
		String par = String.format("COD_FISCALE=%s;ISO6392_COD=ita;SESSIONID=%s", fiscalCode, sid);

		String res = proxy.fn_retrieve_xml(sid, "GET_CURRICULUM", par);

		// Student student = buildStudent(res.value);
		Student student = buildStudentXML(res);

		logout(sid);
		return student;
	}

	public static StudentExams getExams(String fiscalCode) throws Exception {
		String sid = login();
		String par = String.format("COD_FISCALE=%s;ISO6392_COD=ita;SESSIONID=%s", fiscalCode, sid);

		String res = proxy.fn_retrieve_xml(sid, "GET_CURRICULUM", par);

//		List<Exam> exams = buildExams(res.value);
		List<Exam> exams = buildExamsXML(res);
		
		StudentExams.Builder builder = StudentExams.newBuilder();
		builder.setFiscalCode(fiscalCode);
		builder.addAllExams(exams);

		logout(sid);
		return builder.build();
	}

	public static List<AdLog> getAdLogs(String aaOff) throws Exception {
		String sid = login();
		String par = String.format("aa_off_id=%s", aaOff);
		String res = proxy.fn_retrieve_xml(sid, "LISTA_AD_FISICHE", par);

		// List<AdLog> adLogs = buildADLogs(res.value, aaOff);
		List<AdLog> adLogs = buildADLogsXML(res, aaOff);

		logout(sid);
		return adLogs;
	}

	public static ExamDescription getExamDescription(String cod, String aaOff, List<AdLog> logs) throws Exception {

		ExamDescription description = null;
		for (AdLog log : logs) {
			if (log.getCod().equals(cod) && log.getYear().equals(aaOff)) {

				String sid = login();
				String par = String.format("aa_off_id=%s;ad_log_id=%s", aaOff, log.getLogId());
				String res = proxy.fn_retrieve_xml(sid, "CONTENUTI_AD_PDSORD", par);

				// description = buildExamDescription(res.value, cod, aaOff);
				description = buildExamDescriptionXML(res, cod, aaOff);

				logout(sid);
				break;
			}
		}

		if (description == null) {
			ExamDescription.Builder builder = ExamDescription.newBuilder();
			description = builder.build();
		}
		return description;

	}

	public static ExamTeacher getExamTeacher(String cod, String aaOff, List<AdLog> logs) throws Exception {

		ExamTeacher teacher = null;
		for (AdLog log : logs) {
			if (log.getCod().equals(cod) && log.getYear().equals(aaOff)) {

				String sid = login();
				String par = String.format("ad_log_id=%s", log.getLogId());
				String res = proxy.fn_retrieve_xml(sid, "LISTA_DOCENTI_AD", par);

				teacher = buildExamTeacherXML(res, cod, aaOff);

				logout(sid);
				break;
			}
		}

		if (teacher == null) {
			ExamTeacher.Builder builder = ExamTeacher.newBuilder();
			teacher = builder.build();
		}
		return teacher;

	}

	public static CompleteExam mergeExamData(String cod, String aaOff, List<Message> description, List<Message> teacher) {
		CompleteExam.Builder builder = CompleteExam.newBuilder();

		builder.setCod(cod);
		builder.setAaOff(aaOff);

		ExamDescription descr = (ExamDescription) description.get(0);
		ExamTeacher teach = (ExamTeacher) teacher.get(0);

		builder.setDescription(descr);
		builder.setTeacher(teach);

		return builder.build();
	}

	private static String login() throws Exception {
		try {
			init();
			String sid = proxy.fn_dologin("wsesse3client", "wesse3K1");
			return sid;
		} catch (Exception e) {
			log.error("Cannot connect to esse3.");
			throw e;
		}
	}

	private static void logout(String sid) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		proxy.fn_dologout(sid);
	}

	private static Student buildStudentXML(String res) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		Student.Builder student = Student.newBuilder();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new ByteArrayInputStream(res.getBytes()));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr1 = xpath.compile("//COD_FISCALE");
		student.setFiscalCode((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//NOME");
		student.setName((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//COGNOME");
		student.setSurname((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//NAZIONE_RESI_DES/DESCRIZIONE[@codice_lingua='eng']");
		student.setNation((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//SESSO");
		student.setGender((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//DATA_NASCITA");
		student.setDateOfBirth((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//TEL_DOM");
		student.setPhone((String) expr1.evaluate(doc, XPathConstants.STRING));
		expr1 = xpath.compile("//CELLULARE");
		student.setMobile((String) expr1.evaluate(doc, XPathConstants.STRING));
		
		expr1 = xpath.compile("//IND_RESI");
		String street = (String)expr1.evaluate(doc, XPathConstants.STRING);
		expr1 = xpath.compile("//NUM_CIV_RESI");
		String streetN = (String)expr1.evaluate(doc, XPathConstants.STRING);
		expr1 = xpath.compile("//COMUNE_RESI_DES");
		String town = (String)expr1.evaluate(doc, XPathConstants.STRING);
		String address = street + " " + streetN + ", " + town;
		student.setAddress(address);		
		
		expr1 = xpath.compile("//CARRIERE/CARRIERA[1]");
		Node carriera = (Node) expr1.evaluate(doc, XPathConstants.NODE);

		XPathExpression expr2 = xpath.compile("AA_IMMA");
		student.setEnrollmentYear((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("AA_CORSO");
		student.setAcademicYear((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("AA_FC");
		student.setSupplementaryYears((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("CFU_CONS");
		student.setCfu((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("CFU_TOT");
		student.setCfuTotal((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("NUM_ESA_SUP");
		student.setMarksNumber((String) expr2.evaluate(carriera, XPathConstants.STRING));
		expr2 = xpath.compile("MEDIA");
		student.setMarksAverage((String) expr2.evaluate(carriera, XPathConstants.STRING));
		
		expr2 = xpath.compile("CDS_DES/DESCRIZIONE[@codice_lingua='eng']");
		student.setCds((String) expr2.evaluate(carriera, XPathConstants.STRING));

		return student.build();
	}

	private static List<Exam> buildExamsXML(String res) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, ParseException {
		List<Exam> result = new ArrayList<Exam>();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new ByteArrayInputStream(res.getBytes()));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr1 = xpath.compile("//CARRIERE/CARRIERA[1]/ESAMI/ESAME");
		NodeList result1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);

		for (int i = 0; i < result1.getLength(); i++) {
			Exam.Builder builder = Exam.newBuilder();

			XPathExpression expr2 = xpath.compile("COD_AD");
			String cod = (String) expr2.evaluate(result1.item(i), XPathConstants.STRING);
			builder.setCod(cod);
			String id = codesUtil.getAD(cod);
			builder.setId(id);
			expr2 = xpath.compile("PESO");
			builder.setWeight((String) expr2.evaluate(result1.item(i), XPathConstants.STRING));
			expr2 = xpath.compile("LODE_FLG");
			builder.setLode((Integer.parseInt((String) expr2.evaluate(result1.item(i), XPathConstants.STRING)) == 0) ? false : true);
			expr2 = xpath.compile("DATA_SUP_ESA");
			String date = (String) expr2.evaluate(result1.item(i), XPathConstants.STRING);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dataSuperamentoEsame = formatter.parse(date);
			builder.setDate(dataSuperamentoEsame.getTime());
			expr2 = xpath.compile("VOTO");
			String voto = (String) expr2.evaluate(result1.item(i), XPathConstants.STRING);
			expr2 = xpath.compile("GIUDIZIO");
			String giudizio = (String) expr2.evaluate(result1.item(i), XPathConstants.STRING);
			if (voto != null && voto.length() > 0) {
				builder.setResult(voto);
			} else {
				builder.setResult(giudizio);
			}
			
			expr1 = xpath.compile("DES_AD/DESCRIZIONE[@codice_lingua='eng']");
			builder.setName((String) expr1.evaluate(result1.item(i), XPathConstants.STRING));			
			
			result.add(builder.build());
		}

		return result;
	}

	private static List<AdLog> buildADLogsXML(String res, String aaOffId) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<AdLog> adLogs = new ArrayList<AdLog>();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new ByteArrayInputStream(res.getBytes()));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr1 = xpath.compile("//Row");
		NodeList result1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);

		for (int i = 0; i < result1.getLength(); i++) {
			AdLog.Builder builder = AdLog.newBuilder();

			XPathExpression expr2 = xpath.compile("p09_ud_log_pds_ad_log_id");
			builder.setLogId((String) expr2.evaluate(result1.item(i), XPathConstants.STRING));
			expr2 = xpath.compile("p09_ad_gen_cod");
			builder.setCod((String) expr2.evaluate(result1.item(i), XPathConstants.STRING));
			builder.setYear(aaOffId);

			adLogs.add(builder.build());
		}

		return adLogs;
	}

	// TODO multiple
	private static ExamDescription buildExamDescriptionXML(String res, String adCod, String aaOff) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		ExamDescription.Builder builder = ExamDescription.newBuilder();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new ByteArrayInputStream(res.getBytes()));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr1 = xpath.compile("//Row");
		Node result1 = (Node) expr1.evaluate(doc, XPathConstants.NODE);

		XPathExpression expr2 = xpath.compile("contenuti_des");
		String des = (String) expr2.evaluate(result1, XPathConstants.STRING);

		builder.setDescription(des);

		return builder.build();
	}

	// TODO multiple
	public static ExamTeacher buildExamTeacherXML(String res, String adCod, String aaOff) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		ExamTeacher.Builder builder = ExamTeacher.newBuilder();

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new ByteArrayInputStream(res.getBytes()));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr1 = xpath.compile("//Row");
		Node result1 = (Node) expr1.evaluate(doc, XPathConstants.NODE);

		XPathExpression expr2 = xpath.compile("cognome");
		String surname = (String) expr2.evaluate(result1, XPathConstants.STRING);
		expr2 = xpath.compile("nome");
		String name = (String) expr2.evaluate(result1, XPathConstants.STRING);
		// expr2 = xpath.compile("//ad_log_id");
		// String adLogId = (String)expr2.evaluate(result1, XPathConstants.STRING);

		builder.setName(name);
		builder.setSurname(surname);

		return builder.build();

	}

}
