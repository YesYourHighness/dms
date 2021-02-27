package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-Repairlog")
@Data
public class Repairlog {
    @ApiModelProperty(value = "")
    private Integer logid;

    @ApiModelProperty(value = "")
    private Integer deviceid;

    @ApiModelProperty(value = "")
    private Integer userid;

    /**
     * 申请日期
     */
    @ApiModelProperty(value = "申请日期")
    private Date applydate;

    /**
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}