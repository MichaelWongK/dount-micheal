package com.michael.sweet.heart.common.util;

import java.util.UUID;

/**
 * DESCRIPTION: ID工具类
 *
 *  @author michael.wang
 *  @date 2019-09-19 11:54:55
 */
public class IdUtils {

    public static String uuid32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(uuid32());
    }

}
