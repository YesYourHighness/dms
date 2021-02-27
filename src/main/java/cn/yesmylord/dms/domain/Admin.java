package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-Admin")
@Data
public class Admin {
    @ApiModelProperty(value = "")
    private Integer adminid;

    @ApiModelProperty(value = "")
    private Integer userid;

    @ApiModelProperty(value = "")
    private String username;

    @ApiModelProperty(value = "")
    private String password;

    @ApiModelProperty(value = "")
    private Integer state;
}