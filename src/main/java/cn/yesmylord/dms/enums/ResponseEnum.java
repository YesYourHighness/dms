package cn.yesmylord.dms.enums;

import lombok.Getter;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:39
 */
@Getter
public enum ResponseEnum {

    ERROR(-1, "服务端错误"),

    SUCCESS(0, "成功"),

    PASSWORD_ERROR(1, "密码错误"),

    USERNAME_EXIST(2, "用户名已存在"),

    PARAM_ERROR(3, "参数错误"),

    VERIFY_CODE_ERROR(4, "验证码错误"),

    SESSION_ERROR(5, "session发生变化"),

    USERNAME_ERROR(2, "当前用户名不存在")
    ;
    Integer code;
    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
