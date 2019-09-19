package com.michael.sweet.mp;

import com.michael.sweet.heart.common.util.IdUtils;
import com.michael.sweet.heart.platform.organization.entity.UserEntity;
import com.michael.sweet.heart.platform.organization.entity.UserInfoEntity;
import com.michael.sweet.heart.platform.organization.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author michael.wang
 * @date 2019-09-19 14:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    private IUserService userService;

    @Test
    public void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(IdUtils.uuid32());
        userEntity.setUsername("michael");
        userEntity.setPassword("michael");
        String userInfoId = IdUtils.uuid32();
        userEntity.setUserInfoId(userInfoId);
        userEntity.setMainStationId(IdUtils.uuid32());
        userEntity.setStatus(0);
        userEntity.setVisit("我是凯凯王！");

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(userInfoId);
        userInfoEntity.setJobNumber("michael");
        userInfoEntity.setUserChineseName("凯凯王");
        userInfoEntity.setEmail("wangmk@163.com");
        userInfoEntity.setSex("2");
        userInfoEntity.setUserTheme("blue");

        System.out.println(userService.addUser(userEntity, userInfoEntity));

    }

    @Test
    public void getUser() {
        System.out.println(userService.getUserInfo("4028809f45d4ce310145d4d4bb0c0002"));
    }
}
