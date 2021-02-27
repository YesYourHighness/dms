package cn.yesmylord.dms.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:44
 */
@Data
public class AdminLoginForm {
    private String username;
    private String password;
    private String verifyCode;
}
