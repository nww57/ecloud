package com.sunesoft.ecloud.files.biz.application.query;

import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.ecloud.common.utils.BeanUtil;
import com.sunesoft.ecloud.files.biz.application.criterias.FileCriteria;
import com.sunesoft.ecloud.files.biz.application.dtos.*;
import com.sunesoft.ecloud.files.biz.domain.FileInfos;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;
import com.sunesoft.ecloud.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.ecloud.hibernate.sqlExcute.GenericQuery;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Zhouzh
 * @Date: 2018/4/18
 */
@SuppressWarnings("All")
@Service
public class FileQueryServiceImpl extends GenericQuery implements FileQueryService {
    /**
     * 查询文件信息
     *
     * @param fileCriteria
     * @return
     */
    @Override
    public List<FileInfoDto> GetFileInfo(FileCriteria fileCriteria) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(FileInfos.class, "f")
                .where(fileCriteria.getParams())
//                .and("is_latestVersion",1)
                .select(FileInfoDto.class);
        return this.queryList(sqlBuilder);
    }

    @Override
    public FileInfoDto GetFileOne(FileCriteria fileCriteria) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(FileInfos.class, "f")
                .where(fileCriteria.getParams())
                .select(FilePathDto.class);
        List<FileInfoDto> list = this.queryList(sqlBuilder);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    @Override
    public List<FileInfoDto> GetFileInfo(UUID agId, UUID pathId) {

        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(FilePath.class, "p")
                .where("agId", agId.toString())
                .and("id", pathId.toString())
                .select(FilePathDto.class);
        List<FilePathDto> path = this.queryList(sqlBuilder);
        if (path == null || path.size() == 0) {
            return null;
        }
        SqlBuilder builder = HSqlBuilder.hFrom(FileInfos.class, "f")
                .join(FilePath.class, "p")
                .on(" p.id=f.file_path_id")
                .where("p.agId", agId)
                .and("pathIndex", path.get(0).getPathIndex() + "%")
                .select(FilePathDto.class);
        return this.queryList(builder);
    }


    @Override
    public List<PathWithFileDto> GetPathWithFileInfo(FileCriteria fileCriteria) {

        return null;
    }

    @Override
    public PathWithFileDto GetFilePath(UUID agId, String baseRoot) {
        SqlBuilder sqlBuilder = HSqlBuilder.hFrom(FilePath.class, "p")
                .where("agId", agId.toString())
                .and("baseRoot", baseRoot)
                .select(FilePathDto.class);
        List<FilePathDto> path = this.queryList(sqlBuilder);


        SqlBuilder sqlfile = HSqlBuilder.hFrom(FileInfos.class, "f")
                .where("agId", agId.toString())
                .and("baseRoot", baseRoot)
                .select(FileInfoDto.class);
        List<FileInfoDto> file = this.queryList(sqlBuilder);

        return convertToPathWithFile(null, path, file);


    }

    private PathWithFileDto convertToPathWithFile(PathWithFileDto patent, List<FilePathDto> filePathDtos, List<FileInfoDto> fileInfoDtos) {
        PathWithFileDto fileDto = new PathWithFileDto();
        Stream<FilePathDto> filePathchild;
        if (patent == null) {
            filePathchild = filePathDtos.stream().filter(x -> x.getHasParent().equals(false));
            BeanUtil.copyPropertiesIgnoreNull(filePathchild.findFirst().get(), fileDto);

            fileDto = convertToPathWithFile(fileDto, filePathDtos, fileInfoDtos);
            UUID parentId = fileDto.getId();
            List<FileInfoDto> files = fileInfoDtos.stream().filter(i -> parentId.equals(i.getFile_path_id())).collect(Collectors.toList());
            fileDto.setListFiles(files);
            return fileDto;
        } else {
            filePathchild = filePathDtos.stream().filter(x -> x.getParentId().equals(patent.getId()));
            filePathchild.forEach(x -> {
                PathWithFileDto subFile = new PathWithFileDto();
                BeanUtil.copyPropertiesIgnoreNull(x, subFile);
                subFile = convertToPathWithFile(subFile, filePathDtos, fileInfoDtos);
                List<FileInfoDto> files = fileInfoDtos.stream().filter(e -> e.getFile_path_id().equals(patent.getId())).collect(Collectors.toList());
                subFile.setListFiles(files);
                patent.getChilds().add(subFile);

            });
            return patent;
        }
    }


    @Override
    public List<FilePathDto> GetFilePathTempleteAll() {
        return null;
    }

    @Override
    public FilePathDto getFilePathTempleteByType(PathType pathType) {
        return null;
    }

    @Override
    public FilePathDto getFilePathById(UUID id) {
        return null;
    }

    @Override
    public DownloadFileDto getFileById(UUID agId, UUID id) {
        SqlBuilder<FileInfoForDownLoadDto> sqlBuilder = HSqlBuilder.hFrom(FileInfos.class, "p")
                .where("agId", agId.toString())
                .and("id", id)
                .select(FileInfoForDownLoadDto.class);
        FileInfoForDownLoadDto file = this.queryForObject(sqlBuilder);
        DownloadFileDto downdto = new DownloadFileDto();
        try {
            File f = new File(file.getRealPath() + "/" + file.getFileName());
            FileInputStream in = new FileInputStream(f);
            downdto.setFileName(file.getFileName());
            downdto.setExtensions(file.getExtensions());
            downdto.setInputStream(in);
            downdto.setFileLength(f.length());
            downdto.setFileSize(file.getFileSize());
            downdto.setMd5(file.getMd5());
            downdto.setVersionNo(file.getVersionNo());
            return downdto;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ListResult getAgencyAllFile(UUID agId) {
        if (null == agId) {
            throw new IllegalArgumentException("参数agId不能为null");
        }
        SqlBuilder<String> sqlBuilder = HSqlBuilder.hFrom(FileInfos.class, "f")
                .where("f.agId",agId)
                .selectField("f.fileName","fileName");
        List<String> fileNameList = queryList(sqlBuilder);
        fileNameList = fileNameList.stream().map(s->s.substring(0,s.lastIndexOf("."))).collect(Collectors.toList());
        return new ListResult<>(fileNameList);
    }
}
