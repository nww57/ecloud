package com.sunesoft.ecloud.caseclient.dto.xml.list;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 * 包头信息
 */
public class PackageHeader {

    /**
     * 文件包标识(传输之前从服务端获取)
     */
    @XStreamAlias("WENJIANBBZ")
    private String packageId;

    /**
     * 文件个数
     */
    @XStreamAlias("WENJIANGS")
    private int count;

    public PackageHeader(String packageId, int count) {
        this.packageId = packageId;
        this.count = count;
    }
}
