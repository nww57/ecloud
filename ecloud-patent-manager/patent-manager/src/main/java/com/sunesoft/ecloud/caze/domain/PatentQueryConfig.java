package com.sunesoft.ecloud.caze.domain;

import com.sunesoft.ecloud.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/8/008
 * 专利查询配置
 */
@Entity
@Table(name = "pat_patent_query_config")
public class PatentQueryConfig extends IEntity{

    /**
     * 用户id
     */
    @Column(name = "userId",columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID userId;

    /**
     * 到期天数提醒
     */
    @Column(name = "expiredDay")
    private int expiredDay;

    /**
     * 是否标红置顶
     */
    @Column(name = "isRedTop")
    private boolean isRedTop;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(int expiredDay) {
        this.expiredDay = expiredDay;
    }

    public boolean getIsRedTop() {
        return isRedTop;
    }

    public void setIsRedTop(boolean redTop) {
        isRedTop = redTop;
    }
}
