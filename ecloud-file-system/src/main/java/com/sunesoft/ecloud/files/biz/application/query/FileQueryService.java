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

    /**
     * 查询单个文件
     * @param fileCriteria
     * @return
     */
    FileInfoDto GetFileOne(FileCriteria fileCriteria);

    /**
     * 根据目录查询目录下的文件
     * @param agId
     * @param pathId
     * @return
     */
    List<FileInfoDto> GetFileInfo(UUID agId,UUID pathId);

    /**
     * 查询文件目录包含文件
     * @param fileCriteria
     * @return
     */
    List<PathWithFileDto> GetPathWithFileInfo(FileCriteria fileCriteria);

    /**
     * 根据根目录查询所有文件
     * @param agId
     * @param baseRoot
     * @return
     */
    PathWithFileDto GetFilePath(UUID agId, String baseRoot);

    /**
     * 查询模板目录
     * @return
     */
    List<FilePathDto> GetFilePathTempleteAll();

    /**
     * 根据类型查看完整模板目录
     * @param pathType
     * @return
     */
    FilePathDto getFilePathTempleteByType(PathType pathType);

    /**
     *
     * @param id
     * @return
     */
    FilePathDto getFilePathById(UUID id);

    DownloadFileDto getFileById(UUID agId,UUID id);
    DownloadFileDto getPublicFile(UUID id);

    DownloadFileDto getImageFileByName(FileCriteria criteria);
}
