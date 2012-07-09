package smartcampus.service.esse3.data.message;

import java.util.List;
import java.util.LinkedList;

import it.sayservice.xss.api.XSSDataException;
import it.sayservice.xss.api.data.XSSData;
import it.sayservice.xss.api.data.DOMData;

import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;

import it.sayservice.platform.core.message.ProtoBean;
/**
*
* Generated ProtoBean class: DO NOT EDIT!
*
*/
public class Esse3ProtoBean {
   public static class StudentProtoBean implements ProtoBean {
          private String fiscalCode;
    public String getFiscalCode() {
      return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
      this.fiscalCode = fiscalCode;
    }
    
          private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    
          private String surname;
    public String getSurname() {
      return surname;
    }
    public void setSurname(String surname) {
      this.surname = surname;
    }
    
          private String enrollmentYear;
    public String getEnrollmentYear() {
      return enrollmentYear;
    }
    public void setEnrollmentYear(String enrollmentYear) {
      this.enrollmentYear = enrollmentYear;
    }
    
          private String nation;
    public String getNation() {
      return nation;
    }
    public void setNation(String nation) {
      this.nation = nation;
    }
    
          private String academicYear;
    public String getAcademicYear() {
      return academicYear;
    }
    public void setAcademicYear(String academicYear) {
      this.academicYear = academicYear;
    }
    
          private String supplementaryYears;
    public String getSupplementaryYears() {
      return supplementaryYears;
    }
    public void setSupplementaryYears(String supplementaryYears) {
      this.supplementaryYears = supplementaryYears;
    }
    
          private String cfu;
    public String getCfu() {
      return cfu;
    }
    public void setCfu(String cfu) {
      this.cfu = cfu;
    }
    
          private String cfuTotal;
    public String getCfuTotal() {
      return cfuTotal;
    }
    public void setCfuTotal(String cfuTotal) {
      this.cfuTotal = cfuTotal;
    }
    
          private String marksNumber;
    public String getMarksNumber() {
      return marksNumber;
    }
    public void setMarksNumber(String marksNumber) {
      this.marksNumber = marksNumber;
    }
    
          private String marksAverage;
    public String getMarksAverage() {
      return marksAverage;
    }
    public void setMarksAverage(String marksAverage) {
      this.marksAverage = marksAverage;
    }
    
    
    public StudentProtoBean() {
    	super();
    }
    
    public StudentProtoBean(smartcampus.service.esse3.data.message.Esse3.Student reference) {
      super();
                        setFiscalCode(reference.getFiscalCode());
                                    setName(reference.getName());
                                    setSurname(reference.getSurname());
                                    setEnrollmentYear(reference.getEnrollmentYear());
                                    setNation(reference.getNation());
                                    setAcademicYear(reference.getAcademicYear());
                                    setSupplementaryYears(reference.getSupplementaryYears());
                                    setCfu(reference.getCfu());
                                    setCfuTotal(reference.getCfuTotal());
                                    setMarksNumber(reference.getMarksNumber());
                                    setMarksAverage(reference.getMarksAverage());
                      }  

    public StudentProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("fiscalCode") != null && !data.get("fiscalCode").isEmpty()) {
            if (data.get("fiscalCode").size()>1) throw new XSSDataException("Incorrect data cardinality for field fiscalCode: expected single value.");
            
            Object item = data.get("fiscalCode").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field fiscalCode: expected DOMData");
                                  setFiscalCode(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("name") != null && !data.get("name").isEmpty()) {
            if (data.get("name").size()>1) throw new XSSDataException("Incorrect data cardinality for field name: expected single value.");
            
            Object item = data.get("name").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field name: expected DOMData");
                                  setName(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("surname") != null && !data.get("surname").isEmpty()) {
            if (data.get("surname").size()>1) throw new XSSDataException("Incorrect data cardinality for field surname: expected single value.");
            
            Object item = data.get("surname").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field surname: expected DOMData");
                                  setSurname(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("enrollmentYear") != null && !data.get("enrollmentYear").isEmpty()) {
            if (data.get("enrollmentYear").size()>1) throw new XSSDataException("Incorrect data cardinality for field enrollmentYear: expected single value.");
            
            Object item = data.get("enrollmentYear").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field enrollmentYear: expected DOMData");
                                  setEnrollmentYear(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("nation") != null && !data.get("nation").isEmpty()) {
            if (data.get("nation").size()>1) throw new XSSDataException("Incorrect data cardinality for field nation: expected single value.");
            
            Object item = data.get("nation").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field nation: expected DOMData");
                                  setNation(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("academicYear") != null && !data.get("academicYear").isEmpty()) {
            if (data.get("academicYear").size()>1) throw new XSSDataException("Incorrect data cardinality for field academicYear: expected single value.");
            
            Object item = data.get("academicYear").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field academicYear: expected DOMData");
                                  setAcademicYear(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("supplementaryYears") != null && !data.get("supplementaryYears").isEmpty()) {
            if (data.get("supplementaryYears").size()>1) throw new XSSDataException("Incorrect data cardinality for field supplementaryYears: expected single value.");
            
            Object item = data.get("supplementaryYears").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field supplementaryYears: expected DOMData");
                                  setSupplementaryYears(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("cfu") != null && !data.get("cfu").isEmpty()) {
            if (data.get("cfu").size()>1) throw new XSSDataException("Incorrect data cardinality for field cfu: expected single value.");
            
            Object item = data.get("cfu").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cfu: expected DOMData");
                                  setCfu(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("cfuTotal") != null && !data.get("cfuTotal").isEmpty()) {
            if (data.get("cfuTotal").size()>1) throw new XSSDataException("Incorrect data cardinality for field cfuTotal: expected single value.");
            
            Object item = data.get("cfuTotal").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cfuTotal: expected DOMData");
                                  setCfuTotal(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("marksNumber") != null && !data.get("marksNumber").isEmpty()) {
            if (data.get("marksNumber").size()>1) throw new XSSDataException("Incorrect data cardinality for field marksNumber: expected single value.");
            
            Object item = data.get("marksNumber").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field marksNumber: expected DOMData");
                                  setMarksNumber(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("marksAverage") != null && !data.get("marksAverage").isEmpty()) {
            if (data.get("marksAverage").size()>1) throw new XSSDataException("Incorrect data cardinality for field marksAverage: expected single value.");
            
            Object item = data.get("marksAverage").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field marksAverage: expected DOMData");
                                  setMarksAverage(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.Student buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.Student .Builder builder = smartcampus.service.esse3.data.message.Esse3.Student .newBuilder();
                        if (getFiscalCode() != null) {
      	builder.setFiscalCode(getFiscalCode());
      }
                                    if (getName() != null) {
      	builder.setName(getName());
      }
                                    if (getSurname() != null) {
      	builder.setSurname(getSurname());
      }
                                    if (getEnrollmentYear() != null) {
      	builder.setEnrollmentYear(getEnrollmentYear());
      }
                                    if (getNation() != null) {
      	builder.setNation(getNation());
      }
                                    if (getAcademicYear() != null) {
      	builder.setAcademicYear(getAcademicYear());
      }
                                    if (getSupplementaryYears() != null) {
      	builder.setSupplementaryYears(getSupplementaryYears());
      }
                                    if (getCfu() != null) {
      	builder.setCfu(getCfu());
      }
                                    if (getCfuTotal() != null) {
      	builder.setCfuTotal(getCfuTotal());
      }
                                    if (getMarksNumber() != null) {
      	builder.setMarksNumber(getMarksNumber());
      }
                                    if (getMarksAverage() != null) {
      	builder.setMarksAverage(getMarksAverage());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class ExamProtoBean implements ProtoBean {
          private String id;
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    
          private String cod;
    public String getCod() {
      return cod;
    }
    public void setCod(String cod) {
      this.cod = cod;
    }
    
          private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    
          private String result;
    public String getResult() {
      return result;
    }
    public void setResult(String result) {
      this.result = result;
    }
    
          private Boolean lode;
    public Boolean getLode() {
      return lode;
    }
    public void setLode(Boolean lode) {
      this.lode = lode;
    }
    
          private String weight;
    public String getWeight() {
      return weight;
    }
    public void setWeight(String weight) {
      this.weight = weight;
    }
    
          private Long date;
    public Long getDate() {
      return date;
    }
    public void setDate(Long date) {
      this.date = date;
    }
    
    
    public ExamProtoBean() {
    	super();
    }
    
    public ExamProtoBean(smartcampus.service.esse3.data.message.Esse3.Exam reference) {
      super();
                        setId(reference.getId());
                                    setCod(reference.getCod());
                                    setName(reference.getName());
                                    setResult(reference.getResult());
                                    setLode(reference.getLode());
                                    setWeight(reference.getWeight());
                                    setDate(reference.getDate());
                      }  

    public ExamProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("id") != null && !data.get("id").isEmpty()) {
            if (data.get("id").size()>1) throw new XSSDataException("Incorrect data cardinality for field id: expected single value.");
            
            Object item = data.get("id").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field id: expected DOMData");
                                  setId(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("cod") != null && !data.get("cod").isEmpty()) {
            if (data.get("cod").size()>1) throw new XSSDataException("Incorrect data cardinality for field cod: expected single value.");
            
            Object item = data.get("cod").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cod: expected DOMData");
                                  setCod(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("name") != null && !data.get("name").isEmpty()) {
            if (data.get("name").size()>1) throw new XSSDataException("Incorrect data cardinality for field name: expected single value.");
            
            Object item = data.get("name").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field name: expected DOMData");
                                  setName(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("result") != null && !data.get("result").isEmpty()) {
            if (data.get("result").size()>1) throw new XSSDataException("Incorrect data cardinality for field result: expected single value.");
            
            Object item = data.get("result").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field result: expected DOMData");
                                  setResult(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("lode") != null && !data.get("lode").isEmpty()) {
            if (data.get("lode").size()>1) throw new XSSDataException("Incorrect data cardinality for field lode: expected single value.");
            
            Object item = data.get("lode").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field lode: expected DOMData");
                                  setLode(convertToBoolean(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("weight") != null && !data.get("weight").isEmpty()) {
            if (data.get("weight").size()>1) throw new XSSDataException("Incorrect data cardinality for field weight: expected single value.");
            
            Object item = data.get("weight").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field weight: expected DOMData");
                                  setWeight(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("date") != null && !data.get("date").isEmpty()) {
            if (data.get("date").size()>1) throw new XSSDataException("Incorrect data cardinality for field date: expected single value.");
            
            Object item = data.get("date").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field date: expected DOMData");
                                  setDate(convertToLong(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.Exam buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.Exam .Builder builder = smartcampus.service.esse3.data.message.Esse3.Exam .newBuilder();
                        if (getId() != null) {
      	builder.setId(getId());
      }
                                    if (getCod() != null) {
      	builder.setCod(getCod());
      }
                                    if (getName() != null) {
      	builder.setName(getName());
      }
                                    if (getResult() != null) {
      	builder.setResult(getResult());
      }
                                    if (getLode() != null) {
      	builder.setLode(getLode());
      }
                                    if (getWeight() != null) {
      	builder.setWeight(getWeight());
      }
                                    if (getDate() != null) {
      	builder.setDate(getDate());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class StudentExamsProtoBean implements ProtoBean {
          private String fiscalCode;
    public String getFiscalCode() {
      return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
      this.fiscalCode = fiscalCode;
    }
    
          private List<smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean> examsList;
    public List<smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean> getExamsList() {
      return examsList;
    }
    public void setExamsList(List<smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean> examsList) {
      this.examsList = examsList;
    }
    public smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean getExams(int i) {
      return examsList .get(i);
    }
    public int getExamsCount() {
      return examsList .size();
    }
    
    
    public StudentExamsProtoBean() {
    	super();
    }
    
    public StudentExamsProtoBean(smartcampus.service.esse3.data.message.Esse3.StudentExams reference) {
      super();
                        setFiscalCode(reference.getFiscalCode());
                                    if (reference.getExamsList()!=null) {
        examsList = new LinkedList<smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean>();
        for (smartcampus.service.esse3.data.message.Esse3.Exam item : reference.getExamsList()) {
          getExamsList().add(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean(item));
        }
      }
                      }  

    public StudentExamsProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("fiscalCode") != null && !data.get("fiscalCode").isEmpty()) {
            if (data.get("fiscalCode").size()>1) throw new XSSDataException("Incorrect data cardinality for field fiscalCode: expected single value.");
            
            Object item = data.get("fiscalCode").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field fiscalCode: expected DOMData");
                                  setFiscalCode(convertToString(((DOMData)item).getStringValue()));
                                      }
                                examsList = new LinkedList<smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean>();
          if (data.get("exams")!=null) {
            for (Object item : data.get("exams")) {
                              if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field exams: expected XSSData");
                getExamsList().add(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean((XSSData)item));
                          }
          }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.StudentExams buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.StudentExams .Builder builder = smartcampus.service.esse3.data.message.Esse3.StudentExams .newBuilder();
                        if (getFiscalCode() != null) {
      	builder.setFiscalCode(getFiscalCode());
      }
                              if (getExamsList()!=null) {
        for (smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamProtoBean item : getExamsList()) {
                    builder. addExams(item.buildMessage());
                  }
      }
                  return builder.buildPartial();
    }
    
    
  }
  public static class AdLogProtoBean implements ProtoBean {
          private String cod;
    public String getCod() {
      return cod;
    }
    public void setCod(String cod) {
      this.cod = cod;
    }
    
          private String logId;
    public String getLogId() {
      return logId;
    }
    public void setLogId(String logId) {
      this.logId = logId;
    }
    
          private String year;
    public String getYear() {
      return year;
    }
    public void setYear(String year) {
      this.year = year;
    }
    
    
    public AdLogProtoBean() {
    	super();
    }
    
    public AdLogProtoBean(smartcampus.service.esse3.data.message.Esse3.AdLog reference) {
      super();
                        setCod(reference.getCod());
                                    setLogId(reference.getLogId());
                                    setYear(reference.getYear());
                      }  

    public AdLogProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("cod") != null && !data.get("cod").isEmpty()) {
            if (data.get("cod").size()>1) throw new XSSDataException("Incorrect data cardinality for field cod: expected single value.");
            
            Object item = data.get("cod").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cod: expected DOMData");
                                  setCod(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("logId") != null && !data.get("logId").isEmpty()) {
            if (data.get("logId").size()>1) throw new XSSDataException("Incorrect data cardinality for field logId: expected single value.");
            
            Object item = data.get("logId").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field logId: expected DOMData");
                                  setLogId(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("year") != null && !data.get("year").isEmpty()) {
            if (data.get("year").size()>1) throw new XSSDataException("Incorrect data cardinality for field year: expected single value.");
            
            Object item = data.get("year").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field year: expected DOMData");
                                  setYear(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.AdLog buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.AdLog .Builder builder = smartcampus.service.esse3.data.message.Esse3.AdLog .newBuilder();
                        if (getCod() != null) {
      	builder.setCod(getCod());
      }
                                    if (getLogId() != null) {
      	builder.setLogId(getLogId());
      }
                                    if (getYear() != null) {
      	builder.setYear(getYear());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class ExamDescriptionProtoBean implements ProtoBean {
          private String description;
    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    
    
    public ExamDescriptionProtoBean() {
    	super();
    }
    
    public ExamDescriptionProtoBean(smartcampus.service.esse3.data.message.Esse3.ExamDescription reference) {
      super();
                        setDescription(reference.getDescription());
                      }  

    public ExamDescriptionProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("description") != null && !data.get("description").isEmpty()) {
            if (data.get("description").size()>1) throw new XSSDataException("Incorrect data cardinality for field description: expected single value.");
            
            Object item = data.get("description").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field description: expected DOMData");
                                  setDescription(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.ExamDescription buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.ExamDescription .Builder builder = smartcampus.service.esse3.data.message.Esse3.ExamDescription .newBuilder();
                        if (getDescription() != null) {
      	builder.setDescription(getDescription());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class ExamTeacherProtoBean implements ProtoBean {
          private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    
          private String surname;
    public String getSurname() {
      return surname;
    }
    public void setSurname(String surname) {
      this.surname = surname;
    }
    
    
    public ExamTeacherProtoBean() {
    	super();
    }
    
    public ExamTeacherProtoBean(smartcampus.service.esse3.data.message.Esse3.ExamTeacher reference) {
      super();
                        setName(reference.getName());
                                    setSurname(reference.getSurname());
                      }  

    public ExamTeacherProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("name") != null && !data.get("name").isEmpty()) {
            if (data.get("name").size()>1) throw new XSSDataException("Incorrect data cardinality for field name: expected single value.");
            
            Object item = data.get("name").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field name: expected DOMData");
                                  setName(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("surname") != null && !data.get("surname").isEmpty()) {
            if (data.get("surname").size()>1) throw new XSSDataException("Incorrect data cardinality for field surname: expected single value.");
            
            Object item = data.get("surname").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field surname: expected DOMData");
                                  setSurname(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.ExamTeacher buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.ExamTeacher .Builder builder = smartcampus.service.esse3.data.message.Esse3.ExamTeacher .newBuilder();
                        if (getName() != null) {
      	builder.setName(getName());
      }
                                    if (getSurname() != null) {
      	builder.setSurname(getSurname());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class CompleteExamProtoBean implements ProtoBean {
          private String cod;
    public String getCod() {
      return cod;
    }
    public void setCod(String cod) {
      this.cod = cod;
    }
    
          private String aaOff;
    public String getAaOff() {
      return aaOff;
    }
    public void setAaOff(String aaOff) {
      this.aaOff = aaOff;
    }
    
          private smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamDescriptionProtoBean description;
    public smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamDescriptionProtoBean getDescription() {
      return description;
    }
    public void setDescription(smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamDescriptionProtoBean description) {
      this.description = description;
    }
    
          private smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamTeacherProtoBean teacher;
    public smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamTeacherProtoBean getTeacher() {
      return teacher;
    }
    public void setTeacher(smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamTeacherProtoBean teacher) {
      this.teacher = teacher;
    }
    
    
    public CompleteExamProtoBean() {
    	super();
    }
    
    public CompleteExamProtoBean(smartcampus.service.esse3.data.message.Esse3.CompleteExam reference) {
      super();
                        setCod(reference.getCod());
                                    setAaOff(reference.getAaOff());
                                    setDescription(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamDescriptionProtoBean(reference.getDescription()));
                                    setTeacher(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamTeacherProtoBean(reference.getTeacher()));
                      }  

    public CompleteExamProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("cod") != null && !data.get("cod").isEmpty()) {
            if (data.get("cod").size()>1) throw new XSSDataException("Incorrect data cardinality for field cod: expected single value.");
            
            Object item = data.get("cod").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cod: expected DOMData");
                                  setCod(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("aaOff") != null && !data.get("aaOff").isEmpty()) {
            if (data.get("aaOff").size()>1) throw new XSSDataException("Incorrect data cardinality for field aaOff: expected single value.");
            
            Object item = data.get("aaOff").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field aaOff: expected DOMData");
                                  setAaOff(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("description") != null && !data.get("description").isEmpty()) {
            if (data.get("description").size()>1) throw new XSSDataException("Incorrect data cardinality for field description: expected single value.");
            
            Object item = data.get("description").get(0); 
                          if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field description: expected XSSData");
              setDescription(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamDescriptionProtoBean((XSSData)item));
                      }
                                if (data.get("teacher") != null && !data.get("teacher").isEmpty()) {
            if (data.get("teacher").size()>1) throw new XSSDataException("Incorrect data cardinality for field teacher: expected single value.");
            
            Object item = data.get("teacher").get(0); 
                          if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field teacher: expected XSSData");
              setTeacher(new smartcampus.service.esse3.data.message.Esse3ProtoBean.ExamTeacherProtoBean((XSSData)item));
                      }
                  }  

    
    public smartcampus.service.esse3.data.message.Esse3.CompleteExam buildMessage() {
      smartcampus.service.esse3.data.message.Esse3.CompleteExam .Builder builder = smartcampus.service.esse3.data.message.Esse3.CompleteExam .newBuilder();
                        if (getCod() != null) {
      	builder.setCod(getCod());
      }
                                    if (getAaOff() != null) {
      	builder.setAaOff(getAaOff());
      }
                                    if (getDescription() != null) {
      	builder.setDescription(getDescription() .buildMessage());
      }
                                    if (getTeacher() != null) {
      	builder.setTeacher(getTeacher() .buildMessage());
      }
                        return builder.buildPartial();
    }
    
    
  }

 
  protected static double convertToDouble(String value) {
    return Double.parseDouble(value);
  }
  
  protected static float convertToFloat(String value) {
    return Float.parseFloat(value);
  }

  protected static boolean convertToBoolean(String value) {
    return Boolean.parseBoolean(value);
  }

  protected static String convertToString(String value) {
    return value;
  }

  protected static int convertToInteger(String value) {
    return Integer.parseInt(value);
  }

  protected static long convertToLong(String value) {
    return Long.parseLong(value);
  }

  protected static ByteString convertToByteString(String value) {
    try {
      return ByteString.copyFrom(value.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      return ByteString.copyFrom(value.getBytes());
    }
  }
 
}
