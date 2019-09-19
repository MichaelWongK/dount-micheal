package com.michael.sweet.heart.platform.organization.controller;

import com.michael.sweet.heart.common.util.IdUtils;
import com.michael.sweet.heart.platform.organization.entity.UserEntity;
import com.michael.sweet.heart.platform.organization.entity.UserInfoEntity;
import com.michael.sweet.heart.platform.organization.service.IUserService;
import com.michael.sweet.heart.platform.organization.swagger.UserSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author michael.wang <a href="mailto:wangmk13@163.com"/>
 * @date 2019-09-19 13:54
 */
@RestController
@RequestMapping("organization/user")
public class UserController implements UserSwagger {

    @Autowired
    private IUserService userService;

    @Override
    @PostMapping("addUser")
    public String addUser(String username, String jobNumber, String password, Integer status, String mainStationId, String mobile, String descContent, String userChineseName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(IdUtils.uuid32());
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        String userInfoId = IdUtils.uuid32();
        userEntity.setUserInfoId(userInfoId);
        userEntity.setMainStationId(mainStationId);
        userEntity.setStatus(0);
        userEntity.setVisit("我是" + userChineseName);

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(userInfoId);
        userInfoEntity.setJobNumber(jobNumber);
        userInfoEntity.setUserChineseName(userChineseName);
        userInfoEntity.setEmail("wangmk13@163.com");
        userInfoEntity.setSex("2");
        userInfoEntity.setUserTheme("blue");
        String result = "";
        try {
            result = userService.addUser(userEntity, userInfoEntity);
        } catch (Exception e) {
            return "查询异常，请稍后再试";
        }
        return result;
    }

    @Override
    public String modifyUser(String userId, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public String modifyUser(String userId, String username, String userChineseName, List<String> roles, List<String> userIds, Integer status, String mainStationId, String password, String jobNumber, String mobile, String descContent) {
        return null;
    }

    @Override
    public String modifyUserInfo(String userId, UserInfoEntity userInfoEntity) {
        return null;
    }

    @Override
    public String findByPage(String username, List<String> roles, String depName, Integer current, String mainStationId, String mobile, Integer status) {
        return null;
    }

    @Override
    @GetMapping("getUserInfo")
    public String getUserInfo(String userName) {
        UserEntity userEntity = userService.getUserInfo(userName);
        if(userEntity != null ) {
            return userEntity.toString();
        }
        return "用户不存在";
    }

    @Override
    public String userEdit(String userId) {
        return null;
    }

    @Override
    public String getGroupAllUser(String managerId) {
        return null;
    }

    @Override
    public String updateGroupUsers(String managerId, List<String> userIds) {
        return null;
    }

    @Override
    public String listSeats() {
        return null;
    }
}
