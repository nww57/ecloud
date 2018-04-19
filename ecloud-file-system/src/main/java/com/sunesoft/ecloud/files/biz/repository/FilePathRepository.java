package com.sunesoft.ecloud.files.biz.repository;

import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * Created by stephan on 20.03.16.
 */
public interface FilePathRepository extends BaseRepository<FilePath, UUID> {


    //TODO agId
    @Query(value = "select p from FilePath p where p.baseRoot = :baseRoot and p.pathCode = :pathCode")
    List<FilePath> getPathByType( @Param("baseRoot") String baseRoot, @Param("pathCode")String pathCode);


    @Query(value = "select p from FilePath p where p.isTempleteData=1 and p.pathType =:pathType")
    List<FilePath> getPathTemplete(@Param("pathType") PathType pathType);


    @Query(value = "select p from FilePath p where   p.baseRoot = :baseRoot ")
    List<FilePath> getPathByBaseRoot( @Param("baseRoot") String baseRoot);

}
