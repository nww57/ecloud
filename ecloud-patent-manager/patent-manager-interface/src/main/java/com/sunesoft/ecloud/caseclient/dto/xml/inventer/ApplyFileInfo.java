package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class ApplyFileInfo {

    @XStreamAlias("项数")
    private int count;

    @XStreamAlias("申请文件信息")
    private List<ApplyFile> infoList;

    public ApplyFileInfo(int count, List<ApplyFile> infoList) {
        this.count = count;
        this.infoList = infoList;
    }

    public static List<ApplyFile> generateApplyFileInfo(){
        List<ApplyFile> basicFileInfoList = new ArrayList<>();
        basicFileInfoList.add(new ApplyFile(1,"发明专利请求书","110101",4));
        basicFileInfoList.add(new ApplyFile(2,"说明书摘要","100004",0));
        basicFileInfoList.add(new ApplyFile(3,"权利要求书","100001",0));
        basicFileInfoList.add(new ApplyFile(4,"说明书","100002",0));
        basicFileInfoList.add(new ApplyFile(5,"说明书附图","100003",0));
        return basicFileInfoList;
    }
}
