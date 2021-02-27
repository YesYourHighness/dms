package cn.yesmylord.dms.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/22 12:49
 */
@Data
public class AdminChangeForm {

    private String username;
    private String oldPassword;
    private String newPassword;

}
