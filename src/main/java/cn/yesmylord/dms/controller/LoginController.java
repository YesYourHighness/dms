package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.utils.verification.IVerifyCodeGen;
import cn.yesmylord.dms.utils.verification.SimpleCharVerifyCodeGenImpl;
import cn.yesmylord.dms.utils.verification.VerifyCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 董文浩
 * @Date 2021/2/4 11:29
 */
@RestController
@Api(tags = "验证码接口")
@Slf4j
public class LoginController {
    @GetMapping("/verify")
    @ApiOperation("验证码接口")
    public void vertify(HttpSession session, HttpServletResponse response) {
        IVerifyCodeGen verifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            VerifyCode generate = verifyCodeGen.generate(80, 28);
            session.setAttribute("verifyCode",generate.getCode());
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(generate.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("验证码生成错误");
        }

    }
}
