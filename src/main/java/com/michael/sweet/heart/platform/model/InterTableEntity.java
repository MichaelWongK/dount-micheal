package com.michael.sweet.heart.platform.model;

import com.michael.sweet.heart.common.util.IdUtils;

/**
 * DESCRIPTION: 中间表通用实体
 * <code>
 * new InterTableEntity("111111", "222222");
 * new InterTableEntity().setLeftId("111111").setRightId("222222");
 * new InterTableEntity().setId("000000").setLeftId("111111").setRightId("222222");
 * </code>
 *
 *  @author michael.wang
 *  @date 2019-09-19 11:54:55
 */
public class InterTableEntity {

    /**
     * 主键ID（默认32位的UUID）
     */
    private String id = IdUtils.uuid32();

    /**
     * 主表ID
     */
    private String leftId;
    /**
     * 关联表ID
     */
    private String rightId;

    /**
     * 留存列
     */
    private String col;

    /**
     * 留存列
     */
    private String col2;


    public InterTableEntity() {
    }

    public InterTableEntity(String leftId, String rightId) {
        this.leftId = leftId;
        this.rightId = rightId;
    }

    public String getId() {
        return id;
    }

    public InterTableEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getLeftId() {
        return leftId;
    }

    public InterTableEntity setLeftId(String leftId) {
        this.leftId = leftId;
        return this;
    }

    public String getRightId() {
        return rightId;
    }

    public InterTableEntity setRightId(String rightId) {
        this.rightId = rightId;
        return this;
    }

    public String getCol() {
        return col;
    }

    public InterTableEntity setCol(String col) {
        this.col = col;
        return this;
    }

    public String getCol2() {
        return col2;
    }

    public InterTableEntity setCol2(String col2) {
        this.col2 = col2;
        return this;
    }
}
