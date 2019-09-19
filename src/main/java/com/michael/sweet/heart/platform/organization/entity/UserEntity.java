package com.michael.sweet.heart.platform.organization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.michael.sweet.heart.platform.model.BaseEntity;

/**
 * DESCRIPTION: 用户账号密码表
 *
 *  @author michael.wang
 *  @date 2019-09-19 11:54:55
 */
@TableName(value = "DEV_USER")
public class UserEntity extends BaseEntity {

    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 拓展表外键
     */
    private String userInfoId;
    /**
     * -1：禁用；0：锁定；1：活动；
     */
    private Integer status;
    /**
     * 主岗id
     */
    private String mainStationId;
    /**
     * 明文密码
     */
    private String visit;

    /**
     * 用户信息
     */
    @TableField(exist = false)
    private UserInfoEntity userInfo;

    public UserInfoEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoEntity userInfo) {
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMainStationId() {
        return mainStationId;
    }

    public void setMainStationId(String mainStationId) {
        this.mainStationId = mainStationId;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userInfoId='" + userInfoId + '\'' +
                ", status=" + status +
                ", mainStationId='" + mainStationId + '\'' +
                ", visit='" + visit + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
