package com.sunesoft.ecloud.files.biz.application.service.impl;

import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.files.biz.application.dtos.FilePathDto;
import com.sunesoft.ecloud.files.biz.application.service.FilePathService;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;
import com.sunesoft.ecloud.files.biz.repository.FilePathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/4/17
 */
@Service
public class FilePathServiceImpl implements FilePathService {


    @Autowired
    FilePathRepository filePathRepository;

    @Override
    public FilePath getById(UUID uuid) {
        return filePathRepository.findOne(uuid);
    }

    @Override
    public FilePath getPathByType(UUID agId, String baseRoot, String pathCode, PathType pathType) {
        List<FilePath> basePath = filePathRepository.getPathByBaseRoot(baseRoot);
        FilePath path;
        if (basePath == null || basePath.size() == 0) {
            List<FilePath> temp = filePathRepository.getPathTemplete(pathType);
            if (temp == null || temp.size() == 0) {
                return addNewPath(null,agId,baseRoot,pathCode);
                //throw new RuntimeException("PathTemplete not init");
            }
            path = copyPath(temp.get(0), agId, baseRoot,baseRoot);
            filePathRepository.save(path);
        } else {
            path = basePath.get(0);
        }
        FilePath result = getPath(path, pathCode);
        if (result == null) {
            return addNewPath(path,agId,baseRoot,pathCode);

            //throw new RuntimeException("PathTemplete not fit");
        }
        return result;
    }



    private FilePath addNewPath(FilePath parent,UUID agId, String baseRoot, String pathCode){
        FilePath filePath = new FilePath();
        filePath.setPathName(baseRoot);
        filePath.setBaseRoot(baseRoot);
        filePath.setAgId(agId);
        filePath.setPathDesc("");
        filePath.setPathCode(pathCode);
        filePath.setTempleteData(false);
        if(parent!=null){
            filePath.setParent(parent);
        }
        filePathRepository.save(filePath);
        return filePath;
    }


    private FilePath copyPath(FilePath path, UUID agId, String baseRoot, String index) {
        FilePath filePath = new FilePath();
        filePath.setPathName(path.getPathName());
        filePath.setBaseRoot(baseRoot);
        filePath.setAgId(agId);
        filePath.setPathDesc(path.getPathDesc());
        filePath.setPathCode(path.getPathCode());
        filePath.setTempleteData(false);
        filePath.setPathIndex(index);
        if (path.getChildPaths().size() > 0) {
            for (FilePath p : path.getChildPaths()) {
                String nextIndex = filePath.getPathIndex() + "." + p.getPathCode();
                FilePath childPath = copyPath(p, agId, baseRoot,nextIndex);
                filePath.getChildPaths().add(childPath);
            }
        }
        return filePath;
    }


    private FilePath getPath(FilePath path, String pathCode) {

        FilePath filePath = null;
        if (path.getPathCode().equals(pathCode))
            filePath = path;
        else {
            if (path.getChildPaths().size() > 0) {
                for (FilePath p : path.getChildPaths()) {
                    filePath = getPath(p, pathCode);
                    if (filePath != null)
                        break;
                }
            }
        }
        return filePath;
    }

    @Override
    public TResult addOrUpdatePath(FilePathDto pathDto) {

        FilePath path =new FilePath();
        if(pathDto.getId()!=null){
            path = filePathRepository.findOne(pathDto.getId());
        }

        if(pathDto.getParentId()!=null) {
            FilePath patent = new FilePath();
            patent.setId(pathDto.getParentId());
            patent.setParent(patent);
        }

        filePathRepository.save(path);

        return ResultFactory.success();
    }

    @Override
    public TResult deletePath(UUID agId,UUID id) {
        filePathRepository.delete(id);
        return ResultFactory.success();
    }
}
