package com.gp.springboot.utils;

import org.springframework.util.DigestUtils;

/**
 * @author Gp
 * @create 2020/6/3 21:56
 */

/**
 * 什么是MD5, 就是一种校验方式, 一个文件或一个请求对一个唯一的一个MD5值
 * 通过判断这个MD5, 就可以得到数据的正确性
 */
public class MD5Utils {
    private static String MD5 = "$%FYY9gg&guiui8*huh78hue";

    public static String getMD5ByCommodityById(Integer id) {
        String str = id + "/" + MD5;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
