package cn.yesmylord.dms.utils.verification;

import lombok.Data;

/**
 * @author 董文浩
 * @Date 2020/7/26 15:39
 * 验证码类
 */
@Data
public class VerifyCode {

    private String code;

    private byte[] imgBytes;

    private long expireTime;

}