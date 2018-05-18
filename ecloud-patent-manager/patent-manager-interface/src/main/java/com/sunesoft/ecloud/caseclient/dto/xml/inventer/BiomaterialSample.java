package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.XMLDate;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
@XStreamAlias("生物材料样品")
public class BiomaterialSample {

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort ;

    @XStreamAlias("保藏单位")
    private String preservationCompanyCode;

    @XStreamAlias("地址")
    private String preservationCompanyAddress;

    @XStreamAlias("保藏日期")
    private XMLDate preservationDate;

    @XStreamAlias("保藏编号")
    private String preservationCode;

    @XStreamAlias("分类命名")
    private String classification;

    @XStreamAlias("存活情况")
    private Survival survival;

    public BiomaterialSample() {
    }

    public BiomaterialSample(int sort, String preservationCompanyCode, String preservationCompanyAddress, XMLDate preservationDate, String preservationCode, String classification, Survival survival) {
        this.sort = sort;
        this.preservationCompanyCode = preservationCompanyCode;
        this.preservationCompanyAddress = preservationCompanyAddress;
        this.preservationDate = preservationDate;
        this.preservationCode = preservationCode;
        this.classification = classification;
        this.survival = survival;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getPreservationCompanyCode() {
        return preservationCompanyCode;
    }

    public void setPreservationCompanyCode(String preservationCompanyCode) {
        this.preservationCompanyCode = preservationCompanyCode;
    }

    public String getPreservationCompanyAddress() {
        return preservationCompanyAddress;
    }

    public void setPreservationCompanyAddress(String preservationCompanyAddress) {
        this.preservationCompanyAddress = preservationCompanyAddress;
    }

    public XMLDate getPreservationDate() {
        return preservationDate;
    }

    public void setPreservationDate(XMLDate preservationDate) {
        this.preservationDate = preservationDate;
    }

    public String getPreservationCode() {
        return preservationCode;
    }

    public void setPreservationCode(String preservationCode) {
        this.preservationCode = preservationCode;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Survival getSurvival() {
        return survival;
    }

    public void setSurvival(Survival survival) {
        this.survival = survival;
    }


}
