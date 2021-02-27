package cn.yesmylord.dms.utils;

import org.springframework.util.DigestUtils;

import java.util.Locale;

/**
 * @author 董文浩
 * @Date 2021/2/4 11:22
 * md5加密
 */
public class Md5 {
    public static String md5Password(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase(Locale.ROOT);
    }
}
