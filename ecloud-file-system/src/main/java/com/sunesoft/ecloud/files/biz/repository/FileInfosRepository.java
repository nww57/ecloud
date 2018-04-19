package com.sunesoft.ecloud.files.biz.repository;

import com.sunesoft.ecloud.files.biz.domain.FileInfos;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by stephan on 20.03.16.
 */
public interface FileInfosRepository extends BaseRepository<FileInfos, UUID> {


}
