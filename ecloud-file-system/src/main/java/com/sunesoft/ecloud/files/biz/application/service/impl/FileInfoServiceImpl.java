package com.sunesoft.ecloud.files.biz.application.service.impl;

import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;
import com.sunesoft.ecloud.files.biz.application.service.FileInfoService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Override
    public TResult upload(FileInfoDto fileInfoDto) {
        UUID fileId;
        if (fileInfoDto.getId() == null) {
            fileId = UUID.randomUUID();
        } else {
            fileId = fileInfoDto.getId();
        }
        File file = new File("D:\\ecloudFile\\", fileId.toString());
        try {
            FileUtils.copyInputStreamToFile(fileInfoDto.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultFactory.success();
    }

    @Override
    public TResult delete(String fileInfoId) {
        return null;
    }

    @Override
    public TResult Update(FileInfoDto fileInfoDto) {
        return null;
    }

    @Override
    public TResult AddFilePath(FilePathDto filePathDto) {
        return null;
    }

    @Override
    public TResult UpdateFilePath(FilePathDto filePathDto) {
        return null;
    }

    @Override
    public TResult deleteFilePath(Long Id) {
        return null;
    }
}
