package com.sunesoft.ecloud.caseclient.enums;

/**
 * @Auther: niww
 * @Date: 2018/5/4/004
 * 专利节点
 */
public enum  PatentNode {

    /**
     *完善信息
     */
    TOBEIMPROVED(0),
    /**
     *分配工程师
     */
    ALLOTENGINEER(1),
    /**
     *撰稿
     */
    WRITING(2),
    /**
     *打包递交
     */
    PACKAGING(3);


    /**
     * 受理
     */

    /**
     * 授权
     */

    /**
     * 等待证书下发
     */

    /**
     * 结案
     */

    private int node;

    PatentNode(int node) {
        this.node = node;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }
}
