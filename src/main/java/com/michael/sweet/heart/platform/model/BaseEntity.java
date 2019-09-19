package com.michael.sweet.heart.platform.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * DESCRIPTION:
 * 基础的类，主要包含
 * 创建时间、创建人、更新时间、更新人
 *
 * @author donghao.ma
 * @date 2019/5/7 9:51
 */
public class BaseEntity {

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(hidden = true)
    private String createUser;
    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date modifyTime;
    /**
     * 更新人
     */
    @ApiModelProperty(hidden = true)
    private String modifyUser;

    @TableField(exist = false)
    private String createUserName;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
}
