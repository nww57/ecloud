package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class ApplyFileInfo {

    @XStreamAlias("项数")
    private int count;

    @XStreamImplicit(keyFieldName = "申请文件信息",itemFieldName = "申请文件")
    private List<FileInfo> infoList;

    public ApplyFileInfo(int count, List<FileInfo> infoList) {
        this.count = count;
        this.infoList = infoList;
    }

    public static List<FileInfo> generateApplyFileInfo(){
        List<FileInfo> fileInfoList = new ArrayList<>();
        fileInfoList.add(new FileInfo(1,"发明专利请求书","110101",4));
        fileInfoList.add(new FileInfo(2,"说明书摘要","100004",0));
        fileInfoList.add(new FileInfo(3,"权利要求书","100001",0));
        fileInfoList.add(new FileInfo(4,"说明书","100002",0));
        fileInfoList.add(new FileInfo(5,"说明书附图","100003",0));
        return fileInfoList;
    }
}
