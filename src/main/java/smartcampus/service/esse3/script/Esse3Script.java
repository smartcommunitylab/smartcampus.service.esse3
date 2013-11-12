package smartcampus.service.esse3.script;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import smartcampus.service.esse3.data.message.Esse3;
import smartcampus.service.esse3.data.message.Esse3.Ad;
import smartcampus.service.esse3.data.message.Esse3.Cds;
import smartcampus.service.esse3.data.message.Esse3.Facolta;
import smartcampus.service.esse3.data.message.Esse3.Orari;
import smartcampus.service.esse3.data.message.Esse3.Pds;

import com.google.protobuf.Message;

public class Esse3Script {

	public List<Message> getFacolta(String xml) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.facolta");
		Unmarshaller u = jc.createUnmarshaller();

		smartcampus.service.esse3.jaxb.facolta.WS ws = (smartcampus.service.esse3.jaxb.facolta.WS) u.unmarshal(new StringReader(xml));

		for (smartcampus.service.esse3.jaxb.facolta.WS.DataSet.Row row : ws.getDataSet().getRow()) {
			if ("0".equals(row.getWebViewFlg())) {
				continue;
			}
			Facolta.Builder builder = Facolta.newBuilder();
			builder.setFacId(row.getFacId());
			builder.setDescription(row.getDes());
			result.add(builder.build());
		}

		return result;
	}

	public List<String> getClassi(String xml) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.classi");
		Unmarshaller u = jc.createUnmarshaller();

		smartcampus.service.esse3.jaxb.classi.WS ws = (smartcampus.service.esse3.jaxb.classi.WS) u.unmarshal(new StringReader(xml));

		Set<String> cods = new HashSet<String>();
		for (smartcampus.service.esse3.jaxb.classi.WS.DataSet.Row row : ws.getDataSet().getRow()) {
			String cod = row.getTipoCorsoCod();
			cods.add(cod);
		}

		return new ArrayList<String>(cods);
	}

	public List<Message> getCds(String xml, String facId) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.cds");
		Unmarshaller u = jc.createUnmarshaller();

		smartcampus.service.esse3.jaxb.cds.WS ws = (smartcampus.service.esse3.jaxb.cds.WS) u.unmarshal(new StringReader(xml));

		for (smartcampus.service.esse3.jaxb.cds.WS.DataSet.Row row : ws.getDataSet().getRow()) {
			String des = row.getP06CdsDsTipoTitDes();
			if (des.length() == 0) {
				continue;
			}
			if (!row.getFacId().equals(facId)) {
				continue;
			}
			Cds.Builder builder = Cds.newBuilder();
			builder.setCdsId(row.getCdsId());
			builder.setCdsCod(row.getP06CdsCod());
			builder.setDescription(des);
			builder.setFacId(row.getFacId());
			builder.setDurata(row.getDurataAnni());
			builder.setAaOrd(row.getP06CdsordAaOrdId());
			result.add(builder.build());
		}

		return result;
	}
	
	public Cds mergeCdsWithPds(Cds cds, List<Pds> pdss) {
		Cds.Builder builder = Cds.newBuilder(cds);
		builder.addAllPds(pdss);
		return builder.build();
	}

	public List<Message> getPds(String xml) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.pds");
		Unmarshaller u = jc.createUnmarshaller();

		smartcampus.service.esse3.jaxb.pds.WS ws = (smartcampus.service.esse3.jaxb.pds.WS) u.unmarshal(new StringReader(xml));

		for (smartcampus.service.esse3.jaxb.pds.WS.DataSet dataset : ws.getDataSet()) {
			if (!"PDSORD_LIST_DES_LIN_WEB".equals(dataset.getLocalEntityName())) {
				continue;
			}

			for (smartcampus.service.esse3.jaxb.pds.WS.DataSet.Row row : dataset.getRow()) {
				if (!"Attivo".equals(row.getP06StatiOrdDes())) {
					continue;
				}
				Pds.Builder builder = Pds.newBuilder();
//				builder.setAaOrd(row.getAaOrdId());
				builder.setPdsCod(row.getCod());
				builder.setPdsId(row.getPdsId());
				result.add(builder.build());
			}
		}

		return result;
	}

	private List<String> buildADQuery(String aaOff, String aaOrd, String cdsId, List<Message> messages) throws JAXBException {
		List<String> result = new ArrayList<String>();
		// cds_id=10114;aa_ord_id=2008;aa_off_id=2013;pds_id=9999
		for (Message msg : messages) {
			Pds pds = (Pds) msg;
			String s = cdsId + "/" + aaOrd + "/" + aaOff + "/" + pds.getPdsId();
			result.add(s);
		}

		return result;

	}

	public List<String> buildADQuery(String aaOff, String aaOrd, String cdsId, String xml) throws JAXBException {
		List<Message> messages = getPds(xml);
		return buildADQuery(aaOff, aaOrd, cdsId, messages);
	}

	public List<Message> getAd(String ad, String adlog) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc1 = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.ad");
		Unmarshaller u1 = jc1.createUnmarshaller();

		Map<String, Ad.Builder> ads = new TreeMap<String, Esse3.Ad.Builder>();
		List<String> added = new ArrayList<String>();

		smartcampus.service.esse3.jaxb.ad.WS ws1 = (smartcampus.service.esse3.jaxb.ad.WS) u1.unmarshal(new StringReader(ad));

		for (smartcampus.service.esse3.jaxb.ad.WS.DataSet.Row row : ws1.getDataSet().getRow()) {
			Ad.Builder builder = Ad.newBuilder();
			String id = row.getP09AdPdsordAdId();
			builder.setAdId(id);
			builder.setAdcod(row.getP09AdGenCod());
			builder.setDescription(row.getAdGenDes());
			ads.put(id, builder);
		}

		JAXBContext jc2 = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.adlog");
		Unmarshaller u2 = jc2.createUnmarshaller();
		smartcampus.service.esse3.jaxb.adlog.WS ws2 = (smartcampus.service.esse3.jaxb.adlog.WS) u2.unmarshal(new StringReader(adlog));

		for (smartcampus.service.esse3.jaxb.adlog.WS.DataSet.Row row : ws2.getDataSet().getRow()) {
			String id = row.getAdId();
			added.add(id);
			Ad.Builder builder = ads.get(id);
			builder.addDomPart(row.getDomPartCod());
			builder.addFatPart(row.getFatPartCod());
		}

		for (String id : ads.keySet()) {
			if (added.contains(id)) {
				result.add(ads.get(id).build());
			}
		}

		return result;
	}
	
	public List<Message> getOrariAd(String xml) throws JAXBException {
		List<Message> result = new ArrayList<Message>();

		JAXBContext jc = JAXBContext.newInstance("smartcampus.service.esse3.jaxb.orari");
		Unmarshaller u = jc.createUnmarshaller();

		smartcampus.service.esse3.jaxb.orari.WS ws = (smartcampus.service.esse3.jaxb.orari.WS) u.unmarshal(new StringReader(xml));

		for (smartcampus.service.esse3.jaxb.orari.WS.DataSet dataset : ws.getDataSet()) {
			if (!"IMPEGNI".equals(dataset.getLocalEntityName())) {
				continue;
			}

			for (smartcampus.service.esse3.jaxb.orari.WS.DataSet.Row row : dataset.getRow()) {
				Orari.Builder builder = Orari.newBuilder();
				builder.setType(row.getDesTipoAtt());
				builder.setDate(row.getDatDataImp());
				builder.setFrom(row.getOraInizio());
				builder.setTo(row.getOraFine());
				builder.setRoom(row.getDesRf());
				builder.setTeacher(row.getDesPersone());
				result.add(builder.build());
			}
		}

		return result;
	}	
	
	

}
