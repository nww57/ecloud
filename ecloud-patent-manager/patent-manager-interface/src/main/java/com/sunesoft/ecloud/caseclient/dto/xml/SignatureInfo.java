package com.sunesoft.ecloud.caseclient.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 * 签章信息
 */
public class SignatureInfo {

    @XStreamAlias("签章")
    private String signature;

    @XStreamAlias("签章日期")
    private XMLDate xmlDate;

    public SignatureInfo(String signature, XMLDate xmlDate) {
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
