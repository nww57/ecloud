package com.sunesoft.ecloud.caseclient.dto.xml.list;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @auther: niww
 * @date: 2018/5/17/017
 */
public class PackageFileInfo {

    /**
     * 文件标识
     */
    @XStreamAlias("WENJIANBZ")
    private String fileId;


    /**
     * 格式类型
     */
    @XStreamAlias("GESHILX")
    private String formatType;

    /**
     *表格代码
     */
    @XStreamAlias("BIAOGEDM")
    private String fileCode;


    /**
     *（文件）相对路径
     */
    @XStreamAlias("XIANGDUILJ")
    private String fileRoute;

    /**
     *文件版本
     */
    @XStreamAlias("DTDVersion")
    private String fileVersion;

    /**
     *页数
     */
    @XStreamAlias("PAGES")
    private int pages;

    /**
     *项数或幅数 （权利要求书，外观图片与照片）
     */
    @XStreamAlias("COUNTS")
    private int count;

    /**
     *是否补正
     */
    @XStreamAlias("SHIFOUBZ")
    private int bz;

    /**
     *文件名称
     */
    @XStreamAlias("WENJIANMC")
    private String fileName;

    /**
     *证明用途
     */
    @XStreamAlias("ZHENGMINGYT")
    private String useOfProof;

    public PackageFileInfo() {
    }

    public PackageFileInfo(String fileId, String formatType, String fileCode, String fileRoute, String fileVersion, int pages, int count, int bz, String fileName, String useOfProof) {
        this.fileId = fileId;
        this.formatType = formatType;
        this.fileCode = fileCode;
        this.fileRoute = fileRoute;
        this.fileVersion = fileVersion;
        this.pages = pages;
        this.count = count;
        this.bz = bz;
        this.fileName = fileName;
        this.useOfProof = useOfProof;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getFileRoute() {
        return fileRoute;
    }

    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBz() {
        return bz;
    }

    public void setBz(int bz) {
        this.bz = bz;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUseOfProof() {
        return useOfProof;
    }

    public void setUseOfProof(String useOfProof) {
        this.useOfProof = useOfProof;
    }
}
