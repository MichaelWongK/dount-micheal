package com.michael.sweet.heart.platform.organization.service;


import com.michael.sweet.heart.common.mp.PageInfo;
import com.michael.sweet.heart.platform.organization.entity.UserEntity;
import com.michael.sweet.heart.platform.organization.entity.UserInfoEntity;

import java.util.List;

/**
 * DESCRIPTION: 用户
 *
 * @author michael.wang <a href="mailto:wangmk13@163.com"/>
 * @date 2019-09-19 13:54
 */
public interface IUserService {

    /**
     * DESCRIPTION: 新增用户
     *
     * @param userEntity     用户对象
     * @param userInfoEntity 用户信息
     * @return java.lang.String
     * @author michael.wang <a href="mailto:wangmk13@163.com"/>
     * @date 2019-09-19 13:54
     */
    String addUser(UserEntity userEntity, UserInfoEntity userInfoEntity);

    /**
     * 通过用户名登录或者工号登录
     *
     * @param username  用户名
     * @param jobNumber 工号
     * @return 登录结果
     */
    UserEntity login(String username, String jobNumber) ;

    /**
     * DESCRIPTION: 修改用户基本信息
     *
     * @param userEntity     用户相关(账号、状态、主岗等)
     * @param userInfoEntity 用户相关(账号、状态、主岗等)
     * @param roles          角色信息
     * @param manageUsers    管理的人员
     * @return java.lang.String
     */
    String modifyUser(UserEntity userEntity, UserInfoEntity userInfoEntity, List<String> roles, List<String> manageUsers);

    /**
     * DESCRIPTION: 修改用户密码
     *
     * @param userId      用户编号
     * @param oldPassword 原始密码
     * @param newPassword 新的密码
     * @return java.lang.String
     */
    String modifyUser(String userId, String oldPassword, String newPassword);

    /**
     * DESCRIPTION: 修改用户其他信息
     *
     * @param userId         用户编号
     * @param userInfoEntity 用户信息相关
     * @return java.lang.String
     */
    String modifyUserInfo(String userId, UserInfoEntity userInfoEntity);

    /**
     * DESCRIPTION: 分页查询所有用户
     *
     * @param pageInfo       分页对象
     * @param userEntity     用户基本信息
     * @param userInfoEntity 用户其他信息
     * @param roles          角色信息
     * @param depName        部门名字
     * @return java.lang.String
     */
    String findByPage(PageInfo pageInfo, UserEntity userEntity,
                      UserInfoEntity userInfoEntity, List<String> roles, String depName);

    /**
     * 根据部门id查询出对应部门树下是否存在用户
     *
     * @param deptId
     * @return
     */
    Boolean isExitDeptUser(String deptId);

    /**
     * 获取用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    UserEntity getUserInfo(String userId);

    /**
     * 获取用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    UserInfoEntity findUserInfo(String userId);

    /**
     * 修改管理者对应的用户信息
     *
     * @param managerId 管理者id
     * @param userIds   管理者下面对应的用户id集合
     * @return
     */
    String updateGroupUsers(String managerId, List<String> userIds);

    /**
     * 根据管理者id查出下面所有用户的信息
     *
     * @param managerId 管理者id(用户id)
     * @return
     */
    List<UserEntity> getManagerAllUser(String managerId);

    /**
     * DESCRIPTION: 根据部门id查出部门下所有用户信息
     *
     * @param id
     * @return
     */
    List<UserEntity> findUserByDeptId(String id);

    /**
     * DESCRIPTION: 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    UserEntity findUserByUserNameTest();

    /**
     * 全部可用包含锁定的用户id集合
     *
     * @return
     */
    List<String> listAbleUserIds();

    /**
     * 报表页面使用，下拉坐席列表
     *
     * @return 坐席列表
     */
    String listSeatUser();
}
