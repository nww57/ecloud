package com.sunesoft.ecloud.files.biz.application.service;


import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileRelateDto;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
public interface FileInfoService {

    //上传并添加索引
    TResult upload(FileInfoDto fileInfoDto);
    //删除索引
    TResult delete(UUID agId,UUID fileInfoId);

    TResult fileRelate(UUID agId, List<FileRelateDto> fileRelateDto) throws IOException;

}
