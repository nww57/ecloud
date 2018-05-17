package com.sunesoft.ecloud.caseclient.dto.xml.list;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 * 综合信息
 */
@XStreamAlias("data-bus")
public class ColligateInfoDto {

    @XStreamAlias("QINGQIUXX")
    private RequestInfo requestInfo;

    @XStreamAlias("WENJIANBYSXX")
    private PackageOriginalInfo packageOriginalInfo;

    public ColligateInfoDto(RequestInfo requestInfo, PackageOriginalInfo packageOriginalInfo) {
        this.requestInfo = requestInfo;
        this.packageOriginalInfo = packageOriginalInfo;
    }
}
