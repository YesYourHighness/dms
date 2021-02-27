package cn.yesmylord.dms.utils.verification;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 董文浩
 * @Date 2020/7/26 15:39
 */
public interface IVerifyCodeGen {

    /**
     * 生成验证码并返回code，将图片写的os中
     *
     * @param width
     * @param height
     * @param os
     * @return
     * @throws IOException
     */
    String generate(int width, int height, OutputStream os) throws IOException;

    /**
     * 生成验证码对象
     *
     * @param width
     * @param height
     * @return
     * @throws IOException
     */
    VerifyCode generate(int width, int height) throws IOException;
}


