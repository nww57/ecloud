package com.sunesoft.ecloud.admin.domain.flow;

import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @auther: niww
 * @date: 2018/5/24/024
 */
@Entity
@Table(name = "sys_flow_role_user_rel")
public class FlowRoleUser extends IEntity {

    private UUID roleId;

    private UUID userId;

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public FlowRoleUser(UUID roleId, UUID userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
