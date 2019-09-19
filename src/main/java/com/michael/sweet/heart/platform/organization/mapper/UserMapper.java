package com.michael.sweet.heart.platform.organization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.michael.sweet.heart.common.mp.PageInfo;
import com.michael.sweet.heart.platform.organization.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DESCRIPTION: user的数据库操作
 *
 * @author donghao.ma
 * @date 2019/5/7 10:39
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * DESCRIPTION: 分页查询所有用户信息
     *
     * @param page    分页对象
     * @param search  查询对象信息
     * @param roles   角色信息
     * @param depName 部门名字
     * @return PageInfo
     * @date 2019/5/9
     */
    PageInfo<UserEntity> listUser(PageInfo page, @Param("search") UserEntity search,
                                  @Param("roles") List<String> roles, @Param("depName") String depName);



    /**
     * 获取用户详细信息(UserEntity、UserInfoEntity、RoleEntity、DepEntity)
     *
     * @param userId 用户Id
     * @return UserEntity
     */
    UserEntity selectUserInfoDetail(String userId);


}
