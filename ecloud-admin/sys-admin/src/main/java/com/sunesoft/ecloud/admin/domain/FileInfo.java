package com.sunesoft.ecloud.admin.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: niww
 * @Date: 2018/3/25
 */
@Entity
@Table(name = "sys_file_info", schema = "ecloud", catalog = "")
public class SysFileInfoEntity {
    private String id;
    private String fileName;
    private String fileType;
    private String filePath;
    private String md5;
    private Integer fileSize;
    private String fileHeader;
    private Byte isFake;
    private Byte isActive;
    private Timestamp createDatetime;
    private String createBy;
    private Timestamp lastModifyDatetime;
    private String lastModifyBy;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "fileType")
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Basic
    @Column(name = "filePath")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "MD5")
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Basic
    @Column(name = "fileSize")
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Basic
    @Column(name = "fileHeader")
    public String getFileHeader() {
        return fileHeader;
    }

    public void setFileHeader(String fileHeader) {
        this.fileHeader = fileHeader;
    }

    @Basic
    @Column(name = "isFake")
    public Byte getIsFake() {
        return isFake;
    }

    public void setIsFake(Byte isFake) {
        this.isFake = isFake;
    }

    @Basic
    @Column(name = "isActive")
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "createDatetime")
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "lastModifyDatetime")
    public Timestamp getLastModifyDatetime() {
        return lastModifyDatetime;
    }

    public void setLastModifyDatetime(Timestamp lastModifyDatetime) {
        this.lastModifyDatetime = lastModifyDatetime;
    }

    @Basic
    @Column(name = "lastModifyBy")
    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysFileInfoEntity that = (SysFileInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(fileType, that.fileType) &&
                Objects.equals(filePath, that.filePath) &&
                Objects.equals(md5, that.md5) &&
                Objects.equals(fileSize, that.fileSize) &&
                Objects.equals(fileHeader, that.fileHeader) &&
                Objects.equals(isFake, that.isFake) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createDatetime, that.createDatetime) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(lastModifyDatetime, that.lastModifyDatetime) &&
                Objects.equals(lastModifyBy, that.lastModifyBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fileName, fileType, filePath, md5, fileSize, fileHeader, isFake, isActive, createDatetime, createBy, lastModifyDatetime, lastModifyBy);
    }
}
