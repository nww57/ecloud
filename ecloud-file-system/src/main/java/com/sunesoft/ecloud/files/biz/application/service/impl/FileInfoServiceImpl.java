package com.sunesoft.ecloud.files.biz.application.service.impl;

import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.common.utils.StringUtil;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileRelateDto;
import com.sunesoft.ecloud.files.biz.application.service.FileInfoService;
import com.sunesoft.ecloud.files.biz.domain.FileInfos;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;
import com.sunesoft.ecloud.files.biz.repository.FileInfosRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/16
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    FileInfosRepository fileInfosRepository;


    @Value("${file.basePath}")
    private String basePath;


    @Override
    public TResult upload(FileInfoDto fileInfoDto) {
        FileInfos fileInfos = new FileInfos();

        if (fileInfoDto.getCovered()) {
            fileInfos = fileInfosRepository.findOne(fileInfoDto.getId());
        }
        BeanUtil.copyPropertiesIgnoreNull(fileInfoDto, fileInfos);
        if (fileInfoDto.getFile_path_id() != null) {
            FilePath path = new FilePath();
            path.setId(fileInfoDto.getFile_path_id());
            fileInfos.setFilePath(path);
        }
        String filePath = basePath ;
        if(fileInfoDto.getRequirePathType()!=PathType.Globle){
            filePath+= fileInfos.getAgId().toString() + "/";
        }
        if(fileInfoDto.getRequirePathType()==null) {
            fileInfoDto.setRequirePathType(PathType.Oth);
        }
        filePath +=  fileInfoDto.getRequirePathType().toString()+"/";
        if (!StringUtil.isEmpty(fileInfos.getBizType()) && !fileInfos.getBizType().equals("temp")) {
            filePath += fileInfos.getBizType() + "/";
        }
        filePath+=fileInfos.getBaseRoot()+"/";
        fileInfos.setRealPath(filePath);
        fileInfos.setIs_latestVersion(true);
        fileInfosRepository.save(fileInfos);

        File filepath = new File(filePath);
        if (filepath.exists()) {
            try {
                filepath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file = new File(filePath, fileInfos.getFileName());
        try {
            FileUtils.copyInputStreamToFile(fileInfoDto.getInputStream(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultFactory.success(fileInfos.getId());
    }


    @Transactional
    @Override
    public TResult fileRelate(UUID agId, List<FileRelateDto> fileRelateDto) throws IOException {

        List<File> waitDelete = new ArrayList<>();
        for (FileRelateDto relateDto : fileRelateDto) {
            FileInfos fileInfos = fileInfosRepository.findOne(relateDto.getId());
            //暂存路径
            String tempPath = fileInfos.getRealPath();
            BeanUtil.copyPropertiesIgnoreNull(relateDto,fileInfos);
            //重新构造路径
            String filePath = basePath + fileInfos.getAgId().toString() + "/";

            if(StringUtil.isEmpty(relateDto.getRequirePathType())){
                filePath +=  relateDto.getRequirePathType().toString()+"/";            }
            if (!StringUtil.isEmpty(fileInfos.getBizType()) && !fileInfos.getBizType().equals("temp"))
                filePath +=  fileInfos.getBizType()+"/";
            filePath+=fileInfos.getBaseRoot()+"/";
            fileInfos.setRealPath(filePath);
            File source = new File(tempPath+fileInfos.getFileName());
            File target = new File(filePath+fileInfos.getFileName());
            FileUtils.copyFile(source,target);
            fileInfosRepository.save(fileInfos);
            waitDelete.add(source);
        }
        try {
            waitDelete.stream().forEach(x->{
                x.delete();
            });
        }catch (Exception ex){} //DoNothing here
        return ResultFactory.success();
    }


    @Override
    public TResult delete(UUID agId,UUID fileInfoId) {
        FileInfos fileInfos = fileInfosRepository.findOne(fileInfoId);
        if(agId.equals(fileInfos.getAgId())) {
            fileInfosRepository.delete(fileInfoId);

            return ResultFactory.success();
        }else{
            return ResultFactory.error("no Authority delete");
        }

    }

}
