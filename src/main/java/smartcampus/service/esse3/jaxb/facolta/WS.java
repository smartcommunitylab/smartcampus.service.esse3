//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.16 at 12:04:05 PM CEST 
//


package smartcampus.service.esse3.jaxb.facolta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataSet">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Row" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="fac_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="citta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="cod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="des" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="web_view_flg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="url_sito_web" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Num" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="LocalEntityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataSet"
})
@XmlRootElement(name = "WS")
public class WS {

    @XmlElement(name = "DataSet", required = true)
    protected WS.DataSet dataSet;

    /**
     * Gets the value of the dataSet property.
     * 
     * @return
     *     possible object is
     *     {@link WS.DataSet }
     *     
     */
    public WS.DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link WS.DataSet }
     *     
     */
    public void setDataSet(WS.DataSet value) {
        this.dataSet = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Row" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="fac_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="citta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="cod" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="des" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="web_view_flg" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="url_sito_web" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Num" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="LocalEntityName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "row"
    })
    public static class DataSet {

        @XmlElement(name = "Row")
        protected List<WS.DataSet.Row> row;
        @XmlAttribute(name = "LocalEntityName")
        protected String localEntityName;

        /**
         * Gets the value of the row property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the row property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRow().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WS.DataSet.Row }
         * 
         * 
         */
        public List<WS.DataSet.Row> getRow() {
            if (row == null) {
                row = new ArrayList<WS.DataSet.Row>();
            }
            return this.row;
        }

        /**
         * Gets the value of the localEntityName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocalEntityName() {
            return localEntityName;
        }

        /**
         * Sets the value of the localEntityName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocalEntityName(String value) {
            this.localEntityName = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="fac_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="citta" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="cod" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="des" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="web_view_flg" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="url_sito_web" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Num" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "facId",
            "via",
            "citta",
            "prov",
            "cap",
            "cod",
            "des",
            "webViewFlg",
            "urlSitoWeb",
            "email"
        })
        public static class Row {

            @XmlElement(name = "fac_id", required = true)
            protected String facId;
            @XmlElement(required = true)
            protected String via;
            @XmlElement(required = true)
            protected String citta;
            @XmlElement(required = true)
            protected String prov;
            @XmlElement(required = true)
            protected String cap;
            @XmlElement(required = true)
            protected String cod;
            @XmlElement(required = true)
            protected String des;
            @XmlElement(name = "web_view_flg", required = true)
            protected String webViewFlg;
            @XmlElement(name = "url_sito_web", required = true)
            protected String urlSitoWeb;
            @XmlElement(required = true)
            protected String email;
            @XmlAttribute(name = "Num")
            protected String num;

            /**
             * Gets the value of the facId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFacId() {
                return facId;
            }

            /**
             * Sets the value of the facId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFacId(String value) {
                this.facId = value;
            }

            /**
             * Gets the value of the via property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVia() {
                return via;
            }

            /**
             * Sets the value of the via property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVia(String value) {
                this.via = value;
            }

            /**
             * Gets the value of the citta property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCitta() {
                return citta;
            }

            /**
             * Sets the value of the citta property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCitta(String value) {
                this.citta = value;
            }

            /**
             * Gets the value of the prov property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProv() {
                return prov;
            }

            /**
             * Sets the value of the prov property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProv(String value) {
                this.prov = value;
            }

            /**
             * Gets the value of the cap property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCap() {
                return cap;
            }

            /**
             * Sets the value of the cap property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCap(String value) {
                this.cap = value;
            }

            /**
             * Gets the value of the cod property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCod() {
                return cod;
            }

            /**
             * Sets the value of the cod property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCod(String value) {
                this.cod = value;
            }

            /**
             * Gets the value of the des property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDes() {
                return des;
            }

            /**
             * Sets the value of the des property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDes(String value) {
                this.des = value;
            }

            /**
             * Gets the value of the webViewFlg property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWebViewFlg() {
                return webViewFlg;
            }

            /**
             * Sets the value of the webViewFlg property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWebViewFlg(String value) {
                this.webViewFlg = value;
            }

            /**
             * Gets the value of the urlSitoWeb property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrlSitoWeb() {
                return urlSitoWeb;
            }

            /**
             * Sets the value of the urlSitoWeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrlSitoWeb(String value) {
                this.urlSitoWeb = value;
            }

            /**
             * Gets the value of the email property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Sets the value of the email property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
            }

            /**
             * Gets the value of the num property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNum() {
                return num;
            }

            /**
             * Sets the value of the num property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNum(String value) {
                this.num = value;
            }

        }

    }

}
