package com.michael.sweet.heart.common.json;

/**
 * 状态码枚举类
 *
 * @author michael.wang
 * @date 2019/9/27 17:44
 */
public enum CodeEnumType {

    /**
     * 异常错误的规范
     * 不同的模块的错误规范使用各个模块的,系统的使用使用
     *
     * 模块的规范:
     *
     * 例如:组织架构模块
     * ORGANIZATION_USERNAME_WRONG(1001 1001, "用户名错误")
     * 首字母使用模块的名称(ORGANIZATION_) 对应 ((前四位)1001:代表组织机构模块  新增依次递增(1002代表下一个模块))
     * (后四位)1001   : 后四位的第一位 1:校验不通过(例如:账号输入错误,密码输入错误等)
     *                                 9:系统出现的异常(例如:空指针,运行时异常等)
     * WRONG:人员操作的错误
     * ERROR:模块系统出现的问题(例如:插入数据没成功等)
     */


    /**
     * 系统级别(用于提示给前端)
     */
    SYSTEM_SUCCESS(1000, "操作成功", "success"),
    SYSTEM_ERROR_PARAM(9998, "参数错误"),
    SYSTEM_FAILURE(9999, "操作失败"),

    /**
     * 组织架构模块 organization 1001
     */
    ORGANIZATION_USERNAME_WRONG(10011001, "用户名错误"),
    ORGANIZATION_PASSWORD_WRONG(10011002, "密码错误"),
    ORGANIZATION_MENU_IS_EXIST_WRONG(10011003, "已存在相同的菜单，请修改菜单的关键字和名称"),
    ORGANIZATION_USER_NOT_EXIST(10011004, "用户不存在"),
    ORGANIZATION_USER_IS_EXIST(10011005, "账号已被占用"),
    ORGANIZATION_USER_JOB_NUMBER_IS_EXIST(10011006, "同一个工号只能有一个账号"),
    ORGANIZATION_USER_INFO_NOT_EXIST(10011007, "用户信息异常"),
    ORGANIZATION_ROLE_IS_EXIST_WRONG(10011008, "已存在相同的角色，请修改角色名称"),
    ORGANIZATION_USER_OLD_PASSWORD_ERROR(10011009, "原始密码输入错误"),
    ORGANIZATION_DEFAULT_ROLE_CAN_NOT_DELETE(10011010, "系统管理员和默认角色不可删除"),
    ORGANIZATION_USERMANAGER_ERROR(10019001, "用户管理模块异常"),
    ORGANIZATION_ROLE_NAME_NOT_NULL(10019002, "角色名称不能为空"),
    //用于登录时的返回信息
    ORGANIZATION_LOGIN_USER_NOT_EXIST(10019002, "用户名不存在"),
    ORGANIZATION_LOGIN_USER_PASSWORD_ERROR(10019003, "账号或密码错误"),
    ORGANIZATION_LOGIN_USER_DISABLE(10019004, "您的账号已被禁用"),
    ORGANIZATION_LOGIN_USER_PERMISSION_DENIED(10019005, "您的账号无权访问"),
    ORGANIZATION_EXTENSION_NO_NOT_NULL(10019006, "分机号不能为空"),
    ORGANIZATION_EXTENSION_NO_USED(10019007, "当前座机号已被登录，正在通话中，不允许重复登录"),
    ORGANIZATION_EXTENSION_NO_NOT_USED(10019008, "当前座机号已被登录，是否强制登录？"),

    /**
     * 部门相关
     */
    ORGANIZATION_DEPTADD_WRONG(10012001, "部门已存在"),
    ORGANIZATION_STATIONADD_WRONG(10012002, "岗位已存在"),
    ORGANIZATION_DEPT_EXIST_USER_WRONG(10012003, "该部门下存在用户，无法删除"),
    ORGANIZATION_DEPT_DELETE_ERROR(10012004, "系统异常，删除失败"),
    ORGANIZATION_DEPT_STATION_ERROR(10012005, "部门信息异常"),
    ORGANIZATION_DEPT_NAME_ERROR(10012006, "部门名称不能为空"),

    /**
     * 业务相关
     */
    ORGANIZATION_DIM_NOT_INIT(10013001, "系统异常,业务未初始化"),
    ORGANIZATION_DIM_TAG_NOT_FOUND(10013002, "业务不存在"),
    ORGANIZATION_DIM_TAG_NAME_NOT_BLANK(10013003, "业务名称不能为空"),
    ORGANIZATION_DIM_TAG_BIND_USER_NOT_NULL(10013004, "业务绑定的坐席不能为空"),

    /**
     * 校验性异常
     */
    PHONE_NO_FORMAT_ERROR(99990001, "手机号格式错误"),
    DATE_FORMAT_ERROR(99990002, "日期格式错误");




    private Integer code;
    private String message;
    private String status;

    CodeEnumType(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.status = "error";
    }

    CodeEnumType(Integer code, String message, String status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CodeEnumType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
