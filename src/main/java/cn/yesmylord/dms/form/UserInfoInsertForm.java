package cn.yesmylord.dms.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/20 22:07
 */
@Data
public class UserInfoInsertForm {

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer userCard;
}
