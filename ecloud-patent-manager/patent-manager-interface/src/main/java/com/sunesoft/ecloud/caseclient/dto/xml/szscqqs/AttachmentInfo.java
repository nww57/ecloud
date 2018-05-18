package com.sunesoft.ecloud.caseclient.dto.xml.szscqqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 */
@XStreamAlias("分类附件")
public class AttachmentInfo {

    @XStreamAlias("附件名称")
    private String name;

    @XStreamAsAttribute
    @XStreamAlias("顺序")
    private int sort = 1;

    public AttachmentInfo(String name, int sort) {
        this.name = name;
        this.sort = sort;
    }
}
