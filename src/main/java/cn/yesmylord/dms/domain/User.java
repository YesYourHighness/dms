package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-User")
@Data
public class User {
    @ApiModelProperty(value = "")
    private Integer userid;

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private Integer sex;

    @ApiModelProperty(value = "")
    private Date birthday;

    /**
     * 学工号
     */
    @ApiModelProperty(value = "学工号")
    private Integer usercard;
}