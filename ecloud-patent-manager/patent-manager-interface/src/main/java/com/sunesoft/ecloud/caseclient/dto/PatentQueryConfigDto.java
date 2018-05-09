package com.sunesoft.ecloud.caseclient.dto;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/5/8/008
 */
public class PatentQueryConfigDto {
    /**
     * 用户id
     */
    private UUID userId;

    /**
     * 到期天数提醒
     */
    private int expiredDay;

    /**
     * 是否标红置顶
     */
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
