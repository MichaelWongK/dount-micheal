package com.michael.sweet.heart.platform.organization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.michael.sweet.heart.platform.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * DESCRIPTION: 用户详细信息(用户拓展)表
 *
 * @author michael.wang
 * @date 2019-09-19 11:54:55
 */
@TableName(value = "DEV_USER_INFO")
public class UserInfoEntity extends BaseEntity {

    @TableId(type = IdType.UUID)
    @ApiModelProperty(hidden = true)
    private String id;
    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称")
    private String userChineseName;
    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private String jobNumber;
    /**
     * 性别(1男,2女)
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日，格式 yyyy-MM-dd")
    private String birthday;
    /**
     * 移动电话
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 固定电话号
     */
    @ApiModelProperty(value = "固定电话号")
    private String telephone;
    /**
     * 知识库主题
     */
    @ApiModelProperty(value = "系统主题")
    private String userTheme;
    /**
     * 用户ip
     */
    @ApiModelProperty(value = "用户IP")
    private String ip;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String descContent;
    /**
     * 开始时间
     */
    @ApiModelProperty(hidden = true)
    private Date startDate;
    /**
     * 结束时间
     */
    @ApiModelProperty(hidden = true)
    private Date endDate;
    /**
     * 用户头像地址
     */
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserChineseName() {
        return userChineseName;
    }

    public void setUserChineseName(String userChineseName) {
        this.userChineseName = userChineseName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserTheme() {
        return userTheme;
    }

    public void setUserTheme(String userTheme) {
        this.userTheme = userTheme;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescContent() {
        return descContent;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id='" + id + '\'' +
                ", userChineseName='" + userChineseName + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userTheme='" + userTheme + '\'' +
                ", ip='" + ip + '\'' +
                ", descContent='" + descContent + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
