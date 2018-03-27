package com.sunesoft.ecloud.adminclient.dtos;

import java.util.UUID;

/**
 * @Auther: niww
 * @Date: 2018/3/27/
 * 基础dto
 */
public class BasicDto {

    private UUID id;

    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
