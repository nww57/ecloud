package com.sunesoft.ecloud.admin.repository;

import com.sunesoft.ecloud.admin.demon.Orgnization;
import com.sunesoft.ecloud.hibernate.repository.BaseRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Created by stephan on 20.03.16.
 */
public interface OrgnizationRepository extends BaseRepository<Orgnization, UUID> {
}
