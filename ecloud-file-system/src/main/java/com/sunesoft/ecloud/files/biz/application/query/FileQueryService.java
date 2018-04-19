package com.sunesoft.ecloud.files.biz.application.query;


import com.sunesoft.ecloud.files.biz.application.criterias.FileCriteria;
import com.sunesoft.ecloud.files.biz.application.dtos.DownloadFileDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;
import com.sunesoft.ecloud.files.biz.application.dtos.PathWithFileDto;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/13
 */
public interface FileQueryService {

    /**
     * 查询文件信息
     * @param fileCriteria
     * @return
     */
    List<FileInfoDto> GetFileInfo(FileCriteria fileCriteria);
    //检索
    FileInfoDto GetFileOne(FileCriteria fileCriteria);
    //检索
    List<FileInfoDto> GetFileInfo(UUID agId,UUID pathId);

    List<PathWithFileDto> GetPathWithFileInfo(FileCriteria fileCriteria);

    //查询所有目录
    PathWithFileDto GetFilePath(UUID agId, String baseRoot);

    //查询所有目录
    List<FilePathDto> GetFilePathTempleteAll();

    FilePathDto getFilePathTempleteByType(PathType pathType);

    FilePathDto getFilePathById(UUID id);

    DownloadFileDto getFileById(UUID agId,UUID id);
}
