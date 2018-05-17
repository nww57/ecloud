package com.sunesoft.ecloud.caseclient.dto.xml.list;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 * 文件包原始信息
 */
public class PackageOriginalInfo {

    @XStreamAlias("BAOTOUXX")
    private PackageHeader header;

    @XStreamImplicit(itemFieldName = "BAONEIWJXX")
    private List<PackageFileInfo> fileInfoList;

    public PackageOriginalInfo(PackageHeader header, List<PackageFileInfo> fileInfoList) {
        this.header = header;
        this.fileInfoList = fileInfoList;
    }
}
