package com.michael.sweet.heart.common.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.michael.sweet.heart.common.mp.PageInfo;

import java.util.List;

/**
 * 数据列表展示工具类
 *
 * @author michael.wang
 * @date 2019/9/27 17:44
 */
public class JsonResponse {

    public static final String SUCCESS = JsonResponse.toJson(CodeEnumType.SYSTEM_SUCCESS);
    public static final String ERROR_PARAM = JsonResponse.toJson(CodeEnumType.SYSTEM_ERROR_PARAM);

    /**
     * DESCRIPTION: 请求结果 状态码返回
     *
     * @param codeEnumType 全局状态枚举
     * @return java.lang.String
     * @author michael.wang
     * @date 2019/9/27 17:44
     */
    public static String toJson(CodeEnumType codeEnumType) {
        JSONObject json = new JSONObject();
        json.put("code", codeEnumType.getCode());
        json.put("msg", codeEnumType.getMessage());
        json.put("status", codeEnumType.getStatus());
        return toJsonString(json);
    }

    public static String toJson(PageInfo pageInfo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", CodeEnumType.SYSTEM_SUCCESS.getCode());
        jsonObject.put("msg", CodeEnumType.SYSTEM_SUCCESS.getMessage());
        jsonObject.put("status", CodeEnumType.SYSTEM_SUCCESS.getStatus());
        jsonObject.put("data", pageInfo);
        return toJsonString(jsonObject);
    }

    public static <K> String toJson(List<K> list) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", CodeEnumType.SYSTEM_SUCCESS.getCode());
        jsonObject.put("msg", CodeEnumType.SYSTEM_SUCCESS.getMessage());
        jsonObject.put("status", CodeEnumType.SYSTEM_SUCCESS.getStatus());
        jsonObject.put("data", list);
        return toJsonString(jsonObject);
    }

    public static <K> String toJson(K obj) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", CodeEnumType.SYSTEM_SUCCESS.getCode());
        jsonObject.put("msg", CodeEnumType.SYSTEM_SUCCESS.getMessage());
        jsonObject.put("status", CodeEnumType.SYSTEM_SUCCESS.getStatus());
        jsonObject.put("data", obj);
        return toJsonString(jsonObject);
    }

    private static String toJsonString(JSONObject json) {
        return JSONObject.toJSONString(json,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero
        );
    }

}
