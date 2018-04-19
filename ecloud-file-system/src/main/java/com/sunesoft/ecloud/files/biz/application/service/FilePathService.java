package com.sunesoft.ecloud.files.biz.application.service;

import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/17
 */
public interface FilePathService {


    FilePath getById(UUID uuid);

    FilePath getPathByType(UUID agId, String baseRoot, String pathCode, PathType pathType);

    TResult addOrUpdatePath(FilePathDto pathDto);

    TResult deletePath(UUID agId,UUID id);


}
