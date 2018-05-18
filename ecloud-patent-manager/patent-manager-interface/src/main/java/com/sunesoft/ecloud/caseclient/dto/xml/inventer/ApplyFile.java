package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
@XStreamAlias("申请文件")
public class ApplyFile extends BasicFileInfo {
    public ApplyFile(int sort, String fileName, String tableCode, int count) {
        super(sort, fileName, tableCode, count);
    }
}
