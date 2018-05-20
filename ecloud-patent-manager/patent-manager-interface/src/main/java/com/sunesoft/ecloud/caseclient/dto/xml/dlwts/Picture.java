package com.sunesoft.ecloud.caseclient.dto.xml.dlwts;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/16/016
 *  代理委托书-图片信息
 */
@XStreamAlias("图片或照片")
public class Picture {

    @XStreamAlias("说明")
    private String desc;
    @XStreamAlias("文件名称")
    private String fileName;
    @XStreamAsAttribute
    @XStreamAlias("顺序")
    private int sort;

    public Picture(int sort,String desc, String fileName) {
        this.desc = desc;
        this.fileName = fileName;
        this.sort = sort;
    }


}
