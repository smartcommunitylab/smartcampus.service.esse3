package smartcampus.service.esse3.script;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodesUtil {

	private Map<String, String> cds;
	private Map<String, String> aaOrd;
	private Map<String, String> pds;
	private Map<String, String> ad;
	
	private Log log = LogFactory.getLog(this.getClass());
	
//	private static final String PREFIX = "src/main/resources/";
	private static final String PREFIX = "csv/";
	
	public CodesUtil() {
		try {
		cds = new TreeMap<String, String>();
		aaOrd = new TreeMap<String, String>();
		pds = new TreeMap<String, String>();
		ad = new TreeMap<String, String>();		
		
		BufferedReader br = loadCSV(PREFIX + "cds.csv");
		String str;
		while ((str = br.readLine()) != null) {
			String[] line = str.split(";");
			cds.put(line[1], line[0]);
		}
		
		br = loadCSV(PREFIX + "pds.csv");
		while ((str = br.readLine()) != null) {
			String[] line = str.split(";");
			aaOrd.put(line[2], line[0]);
			pds.put(line[2], line[1]);
		}
		
		br = loadCSV(PREFIX + "ad.csv");
		while ((str = br.readLine()) != null) {
			String[] line = str.split(";");
			ad.put(line[1], line[0]);
		}
		} catch (Exception e) {
			log.error("Error initializing codes util.");
			e.printStackTrace();
		}
	}
	
	private void loadCSV(String fileName, Map output, int key, int value) throws IOException {
		FileInputStream fstream = new FileInputStream(fileName);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str;
		while ((str = br.readLine()) != null) {
			String[] line = str.split(";");
			output.put(line[key], line[value]);
		}
	}
	
	private BufferedReader loadCSV(String fileName) throws IOException {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		return br;
	}
	
	public String getCDS(String cod) {
		return cds.get(cod);
	}
	
	public String getPDS(String cod) {
		return pds.get(cod);
	}
	
	public String getAAOrd(String pdsCod) {
		return aaOrd.get(pdsCod);
	}
	
	public String getAD(String cod) {
		return ad.get(cod);
	}

}
