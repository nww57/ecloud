package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
public class AppearanceAttachFileInfo {

    @XStreamImplicit
    private List<AttachFile> fileList;

    @XStreamAlias("总委托书编号")
    private String entrustNo;

    @XStreamAlias("备案编号")
    private String recordNo;

    public AppearanceAttachFileInfo(List<AttachFile> fileList) {
        this.fileList = fileList;
        this.entrustNo = "";
        this.recordNo = "";
    }

    public AppearanceAttachFileInfo(List<AttachFile> fileList, String entrustNo, String recordNo) {
        this.fileList = fileList;
        this.entrustNo = StringUtils.isEmpty(entrustNo)?"":entrustNo;
        this.recordNo = StringUtils.isEmpty(recordNo)?"":recordNo;
    }

}
