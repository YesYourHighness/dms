package cn.yesmylord.dms.form;

import cn.yesmylord.dms.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/14 23:41
 */
@Data
public class UserInfoForm {
    @NotNull
    private Integer userId;

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer userCard;
}
