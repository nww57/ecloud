package com.sunesoft.ecloud.admin.domain.agency;

import com.sunesoft.ecloud.admin.domain.agency.Agency;
import com.sunesoft.ecloud.hibernate.IEntity;

import javax.persistence.*;

/**
 * @Author: niww
 * @Date: 2018/3/25
 * 文件
 */
@Entity
@Table(name = "sys_file_info", schema = "ecloud", catalog = "")
public class AgencyFileInfo extends IEntity{

    /**
     * 文件名称
     */
    private String fileName;
    /**
     *文件类型
     */
    private String fileType;
    /**
     *文件路径
     */
    private String filePath;
    /**
     *md5
     */
    private String md5;
    /**
     *文件大小
     */
    private Integer fileSize;
    /**
     *文件头
     */
    private String fileHeader;
    /**
     *isFake
     */
    private Byte isFake;
    /**
     *是否有效
     */
    private Byte isActive;

    @ManyToOne
    private Agency company;


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

    public Agency getCompany() {
        return company;
    }

    public void setCompany(Agency company) {
        this.company = company;
    }
}
