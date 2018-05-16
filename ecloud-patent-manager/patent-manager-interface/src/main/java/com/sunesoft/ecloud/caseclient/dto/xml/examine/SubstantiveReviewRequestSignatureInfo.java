package com.sunesoft.ecloud.caseclient.dto.xml.examine;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class SubstantiveReviewRequestSignatureInfo {

    @XStreamAlias("签章")
    private String signature;

    @XStreamAlias("签章日期")
    private XMLDate xmlDate;

    public SubstantiveReviewRequestSignatureInfo(String signature, XMLDate xmlDate) {
        this.signature = signature;
        this.xmlDate = xmlDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public XMLDate getXmlDate() {
        return xmlDate;
    }

    public void setXmlDate(XMLDate xmlDate) {
        this.xmlDate = xmlDate;
    }
}
