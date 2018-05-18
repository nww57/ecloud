package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class AbstractPicture {

    @XStreamAlias("图号")
    private int abstractPicture;

    public AbstractPicture(int abstractPicture) {
        this.abstractPicture = abstractPicture;
    }
}
