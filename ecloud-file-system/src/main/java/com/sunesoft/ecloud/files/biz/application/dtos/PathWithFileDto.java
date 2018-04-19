package com.sunesoft.ecloud.files.biz.application.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
public class PathWithFileDto extends FilePathWithChildDto{

    List<FileInfoDto> listFiles = new ArrayList<>();

    public List<FileInfoDto> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<FileInfoDto> listFiles) {
        this.listFiles = listFiles;
    }
}
