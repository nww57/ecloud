package com.sunesoft.ecloud.caseclient.dto.xml.inventer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
@XStreamAlias("附加文件")
public class AttachFile extends BasicFileInfo {
    public AttachFile(int sort, String fileName, String tableCode, int count) {
        super(sort, fileName, tableCode, count);
    }
}
