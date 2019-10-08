package com.michael.sweet.heart.platform.organization.service.impl;

import com.michael.sweet.heart.common.json.JsonResponse;
import com.michael.sweet.heart.common.mp.PageInfo;
import com.michael.sweet.heart.config.exception.SweetException;
import com.michael.sweet.heart.platform.organization.entity.UserEntity;
import com.michael.sweet.heart.platform.organization.entity.UserInfoEntity;
import com.michael.sweet.heart.platform.organization.mapper.UserInfoMapper;
import com.michael.sweet.heart.platform.organization.mapper.UserMapper;
import com.michael.sweet.heart.platform.organization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DESCRIPTION: 用户操作相关
 *
 * @author donghao.ma
 * @date 2019/5/7 11:38
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public String addUser(UserEntity userEntity, UserInfoEntity userInfoEntity) throws SweetException {
        userMapper.insert(userEntity);
        userInfoMapper.insert(userInfoEntity);
        return JsonResponse.SUCCESS;
    }

    @Override
    public UserEntity getUserInfo(String userName) {
        return userMapper.selectUserInfoDetail(userName);
    }

    @Override
    public UserEntity login(String username, String jobNumber) {
        return null;
    }

    @Override
    public String modifyUser(UserEntity userEntity, UserInfoEntity userInfoEntity, List<String> roles, List<String> manageUsers) {
        return null;
    }

    @Override
    public String modifyUser(String userId, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public String modifyUserInfo(String userId, UserInfoEntity userInfoEntity) {
        return null;
    }

    @Override
    public String findByPage(PageInfo pageInfo, UserEntity userEntity, UserInfoEntity userInfoEntity, List<String> roles, String depName) {
        return null;
    }

    @Override
    public Boolean isExitDeptUser(String deptId) {
        return null;
    }


    @Override
    public UserInfoEntity findUserInfo(String userId) {
        return null;
    }

    @Override
    public String updateGroupUsers(String managerId, List<String> userIds) {
        return null;
    }

    @Override
    public List<UserEntity> getManagerAllUser(String managerId) {
        return null;
    }

    @Override
    public List<UserEntity> findUserByDeptId(String id) {
        return null;
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        return null;
    }

    @Override
    public UserEntity findUserByUserNameTest() {
        return null;
    }

    @Override
    public List<String> listAbleUserIds() {
        return null;
    }

    @Override
    public String listSeatUser() {
        return null;
    }
}
