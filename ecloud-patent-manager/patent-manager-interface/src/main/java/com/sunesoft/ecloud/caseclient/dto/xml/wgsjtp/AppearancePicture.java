package com.sunesoft.ecloud.caseclient.dto.xml.wgsjtp;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class AppearancePicture {

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort;

    @XStreamAlias("宽度")
    @XStreamAsAttribute
    private String width;

    @XStreamAlias("高度")
    @XStreamAsAttribute
    private String height;

    @XStreamAlias("视图名称")
    private String viewName;

    @XStreamAlias("文件类型")
    private String fileType;

    @XStreamAlias("文件名称")
    private String fileName;

    public AppearancePicture() {
    }

    public AppearancePicture(int sort, String width, String height, String viewName, String fileType, String fileName) {
        this.sort = sort;
        this.width = width;
        this.height = height;
        this.viewName = viewName;
        this.fileType = fileType;
        this.fileName = fileName;
    }
}
