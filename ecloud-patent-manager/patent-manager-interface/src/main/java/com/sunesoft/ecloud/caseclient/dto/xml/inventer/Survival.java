package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.sunesoft.ecloud.caseclient.dto.xml.examine.converter.AdditionalConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class Survival {

    @XStreamOmitField
    private Boolean survival;

    @XStreamAlias("存活")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean survive;

    @XStreamAlias("未存活")
    @XStreamConverter(value = AdditionalConverter.class)
    private boolean unsurvive;

    public Survival() {
    }

    public Survival(Boolean survival) {
        if(null == survival){
            this.survive = false;
            this.unsurvive = false;
        }else{
            if(survival){
                this.survive = true;
            }else{
                this.unsurvive = true;
            }
        }

    }
}