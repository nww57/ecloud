package com.sunesoft.ecloud.caseclient.dto.xml.examine;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
public class GiveUpActiveModifyRight {

    @XStreamAlias("附加")
    private int giveUp = 1;

    public int getGiveUp() {
        return giveUp;
    }

    public void setGiveUp(int giveUp) {
        this.giveUp = giveUp;
    }
}
