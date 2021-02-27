package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-Category")
@Data
public class Category {
    @ApiModelProperty(value = "")
    private Integer categoryid;

    @ApiModelProperty(value = "")
    private String categoryname;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


    private Integer state;
}