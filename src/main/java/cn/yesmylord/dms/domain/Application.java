package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-Application")
@Data
public class Application {
    @ApiModelProperty(value = "")
    private Integer applicationid;

    @ApiModelProperty(value = "")
    private Integer userid;

    /**
     * 申请设备名
     */
    @ApiModelProperty(value = "申请设备名")
    private String applyname;

    /**
     * 申请购买数量
     */
    @ApiModelProperty(value = "申请购买数量")
    private Integer num;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Date applydate;

    /**
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    /**
     * 状态：0发出申请、1申请成功、2申请拒绝、3申请搁置
     */
    @ApiModelProperty(value = "状态：0发出申请、1申请成功、2申请拒绝、3申请搁置")
    private Integer state;
}