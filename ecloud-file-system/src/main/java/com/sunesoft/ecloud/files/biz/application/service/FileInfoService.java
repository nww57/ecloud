package com.sunesoft.ecloud.files.biz.application.service;


import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;

/**
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
public interface FileInfoService {

    //上传并添加索引
    TResult upload(FileInfoDto fileInfoDto);
    //删除索引
    TResult delete(String fileInfoId);
    //修改文件路径
    TResult Update(FileInfoDto fileInfoDto);
    //增FilePath
    TResult AddFilePath(FilePathDto filePathDto);
    //修改FilePath
    TResult UpdateFilePath(FilePathDto filePathDto);
    //删除FilePath
    TResult deleteFilePath(Long Id);



}
