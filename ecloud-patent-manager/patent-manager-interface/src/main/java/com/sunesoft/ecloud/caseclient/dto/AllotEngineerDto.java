package com.sunesoft.ecloud.caseclient.dto;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @Author: niww
 * @Date: 2018/5/6
 */
public class AllotEngineerDto {

    /**
     * 专利id
     */
    private UUID patentId;

    /**
     *工程师id
     */
    private UUID engineerId;

    /**
     *撰写截止日
     */
    private LocalDate writeExpiryDate;

    public UUID getPatentId() {
        return patentId;
    }

    public void setPatentId(UUID patentId) {
        this.patentId = patentId;
    }

    public UUID getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(UUID engineerId) {
        this.engineerId = engineerId;
    }

    public LocalDate getWriteExpiryDate() {
        return writeExpiryDate;
    }

    public void setWriteExpiryDate(LocalDate writeExpiryDate) {
        this.writeExpiryDate = writeExpiryDate;
    }
}
