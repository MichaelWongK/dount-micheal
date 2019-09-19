package com.michael.sweet.heart.platform.organization.swagger;

import com.michael.sweet.heart.platform.organization.entity.UserInfoEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * DESCRIPTION: Swagger By UserController
 *
 *  @author michael.wang
 *  @date 2019-09-19 11:54:55
 */
@Api(tags = "用户管理")
public interface UserSwagger {
    /**
     * 新建人员
     */
    @ApiOperation(value = "新建人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "jobNumber", value = "工号", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "status", value = "状态(-1：禁用；0：锁定；1：活动)", dataType = "int", paramType = "form", required = true),
            @ApiImplicitParam(name = "mainStationId", value = "所属机构", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "descContent", value = "备注", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "userChineseName", value = "用户中文名", dataType = "String", paramType = "form", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 10011005, message = "用户名已被占用"),
            @ApiResponse(code = 10011006, message = "同一个工号只能有一个账号")
    })
    String addUser(@RequestParam(value = "username") String username,
                   @RequestParam(value = "jobNumber") String jobNumber,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "status") Integer status,
                   @RequestParam(value = "mainStationId", required = false) String mainStationId,
                   @RequestParam(value = "mobile", required = false) String mobile,
                   @RequestParam(value = "descContent", required = false) String descContent,
                   @RequestParam(value = "userChineseName") String userChineseName);

    /**
     * 修改用户密码
     */
    @ApiOperation(value = "修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "oldPassword", value = "原始密码", dataType = "String", paramType = "form", required = false),
            @ApiImplicitParam(name = "newPassword", value = "新的密码", dataType = "String", paramType = "form", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 10011004, message = "用户不存在"),
            @ApiResponse(code = 10011009, message = "原始密码输入错误")
    })
    String modifyUser(@RequestParam(value = "userId") String userId,
                      @RequestParam(value = "oldPassword", required = false) String oldPassword,
                      @RequestParam(value = "newPassword") String newPassword);

    /**
     * 修改账号信息(账号、角色、状态、所属机构)
     */
    @ApiOperation(value = "修改账号信息(账号、角色、状态、所属机构)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "form", required = true),
            @ApiImplicitParam(name = "username", value = "账号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "userChineseName", value = "用户中文名", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "roles", value = "角色列表", dataType = "List", paramType = "form"),
            @ApiImplicitParam(name = "userIds", value = "管理的人员", dataType = "List", paramType = "form"),
            @ApiImplicitParam(name = "status", value = "状态(-1：禁用；0：锁定；1：活动)", dataType = "int", paramType = "form"),
            @ApiImplicitParam(name = "mainStationId", value = "所属机构", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "jobNumber", value = "工号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "descContent", value = "备注", dataType = "String", paramType = "form")
    })
    @ApiResponses({
            @ApiResponse(code = 10011004, message = "用户不存在"),
            @ApiResponse(code = 10011005, message = "用户名已被占用"),
            @ApiResponse(code = 10011006, message = "同一个工号只能有一个账号")
    })
    String modifyUser(@RequestParam(value = "userId") String userId,
                      @RequestParam(value = "username", required = false) String username,
                      @RequestParam(value = "userChineseName", required = false) String userChineseName,
                      @RequestParam(value = "roles", required = false) List<String> roles,
                      @RequestParam(value = "userIds", required = false) List<String> userIds,
                      @RequestParam(value = "status", required = false) Integer status,
                      @RequestParam(value = "mainStationId", required = false) String mainStationId,
                      @RequestParam(value = "password", required = false) String password,
                      @RequestParam(value = "jobNumber", required = false) String jobNumber,
                      @RequestParam(value = "mobile", required = false) String mobile,
                      @RequestParam(value = "descContent", required = false) String descContent);

    /**
     * 修改用户信息（已隐藏此swagger接口）
     */
    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "form", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 10011004, message = "用户不存在"),
            @ApiResponse(code = 10011006, message = "同一个工号只能有一个账号")
    })
    @ApiIgnore
    String modifyUserInfo(@RequestParam(value = "userId") String userId, @ModelAttribute UserInfoEntity userInfoEntity);

    /**
     * 查询用户信息
     */
    @ApiOperation(value = "人员管理列表", notes = "{  \n" +
            "  \"msg\": \"操作成功\",  \n" +
            "  \"code\": 1000,  \n" +
            "  \"status\": \"success\"  \n" +
            "  \"data\": {  \n" +
            "    \"current\": \"int(页码)\",  \n" +
            "    \"pages\": 1,  \n" +
            "    \"searchCount\": true,  \n" +
            "    \"size\": \"int(当前页数据条数)\",  \n" +
            "    \"total\": \"int(总共数据数)\",  \n" +
            "    \"records\": [  \n" +
            "      {  \n" +
            "        \"userId\": \"用户ID\",  \n" +
            "        \"username\": \"admin\",  \n" +
            "        \"jobNumber\": \"工号\",  \n" +
            "        \"mobile\": \"134567890\",  \n" +
            "        \"roles\": \"[{\"roleId\": 666,\"roleName\": \"NAME\"}]\",  \n" +
            "        \"manageUsers\": \"[{\"userId\": 1000001,\"userName\": \"HELLO\"}]\",  \n" +
            "        \"status\": \"int(-1：禁用；0：锁定；1：活动；)\"  \n" +
            "        \"chineseName\": \"无双\",  \n" +
            "        \"department\": \"客服部\",  \n" +
            "        \"createTime\": \"2019-05-15 11:18:22\",  \n" +
            "      }  \n" +
            "    ]  \n" +
            "  }  \n" +
            "}  \n")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "人员名称", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "roles", value = "角色列表", dataType = "List", paramType = "form"),
            @ApiImplicitParam(name = "depdepNames", value = "部门", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "status", value = "状态(-1：禁用；0：锁定；1：活动)", dataType = "int", paramType = "form"),
            @ApiImplicitParam(name = "mainStationId", value = "所属机构", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "current", value = "页码", dataType = "int", paramType = "form")
    })
    String findByPage(@RequestParam(value = "username", required = false) String username,
                      @RequestParam(value = "roles", required = false) List<String> roles,
                      @RequestParam(value = "depName", required = false) String depName,
                      @RequestParam(value = "current", required = false) Integer current,
                      @RequestParam(value = "mainStationId", required = false) String mainStationId,
                      @RequestParam(value = "mobile", required = false) String mobile,
                      @RequestParam(value = "status", required = false) Integer status);

    /**
     * 查询单个用户信息
     */
    @ApiOperation(value = "获取用户信息,根据userName获取", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户ID", dataType = "String", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1000, message = "操作成功")
    })
    String getUserInfo(String userName);

    @ApiOperation(value = "根据用户id查询出该用户的信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1000, message = "操作成功")
    })
    String userEdit(String userId);

    @ApiOperation(value = "根据管理者id查询出所有用户的信息", notes = "结果为用户的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "managerId", value = "管理者ID", dataType = "String", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1000, message = "操作成功")
    })
    String getGroupAllUser(String managerId);

    @ApiOperation(value = "管理者修改组下的用户", notes = "管理者修改组下的用户 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "managerId", value = "管理者ID", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "userIds", value = "用户列表", dataType = "String", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1000, message = "操作成功")
    })
    String updateGroupUsers(@RequestParam(value = "managerId") String managerId, @RequestParam(value = "userIds") List<String> userIds);

    @ApiOperation(value = "报表页面坐席列表", notes = "")
    @ApiResponses({
            @ApiResponse(code = 1000, message = "操作成功")
    })
    String listSeats();
}
