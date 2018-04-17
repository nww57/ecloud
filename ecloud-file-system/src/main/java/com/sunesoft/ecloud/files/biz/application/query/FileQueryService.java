package com.sunesoft.ecloud.files.biz.application.query;


import com.sunesoft.ecloud.common.result.PagedResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.files.biz.application.criterias.FileCriteria;
import com.sunesoft.ecloud.files.biz.application.dtos.DownloadFileDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
public interface FileQueryService {

    //检索
    List<FileInfoDto> GetFileInfo(FileCriteria fileCriteria);

    PagedResult<FileInfoDto> GetFileInfoPaged(FileCriteria fileCriteria);
    //查询所有目录
    List<FilePathDto> GetFilePath(UUID id);
    //查询所有目录
    List<FilePathDto> GetFilePath(UUID agId,String  baseRoot);

    FilePathDto getFilePathById(UUID id);

    DownloadFileDto getFileById(UUID id);
}
