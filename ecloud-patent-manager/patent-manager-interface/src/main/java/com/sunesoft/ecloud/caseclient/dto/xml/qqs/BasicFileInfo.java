package com.sunesoft.ecloud.caseclient.dto.xml.qqs;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class BasicFileInfo {

    @XStreamAlias("顺序")
    @XStreamAsAttribute
    private int sort;

    @XStreamAlias("文件名称")
    private String fileName;

    @XStreamAlias("表格代码")
    private String tableCode;

    @XStreamAlias("页数")
    private int count;

    public BasicFileInfo(int sort, String fileName, String tableCode, int count) {
        this.sort = sort;
        this.fileName = fileName;
        this.tableCode = tableCode;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
