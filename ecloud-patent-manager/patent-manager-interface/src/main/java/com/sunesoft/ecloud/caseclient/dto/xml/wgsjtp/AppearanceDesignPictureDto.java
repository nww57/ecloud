package com.sunesoft.ecloud.caseclient.dto.xml.wgsjtp;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @auther: niww
 * @date: 2018/5/18/018
 */
@XStreamAlias("外观设计图片或照片")
public class AppearanceDesignPictureDto {

    @XStreamImplicit(itemFieldName = "图片或照片")
    private List<AppearancePicture> pictureLit;

    public AppearanceDesignPictureDto(List<AppearancePicture> pictureLit) {
        this.pictureLit = pictureLit;
    }
}
