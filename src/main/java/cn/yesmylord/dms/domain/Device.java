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
@ApiModel(value = "cn-yesmylord-dms-domain-Device")
@Data
public class Device {
    @ApiModelProperty(value = "")
    private Integer deviceid;

    @ApiModelProperty(value = "")
    private String devicename;

    @ApiModelProperty(value = "")
    private Integer categoryid;

    @ApiModelProperty(value = "")
    private Integer userid;

    @ApiModelProperty(value = "")
    private BigDecimal price;

    /**
     * 设备状态：0空闲、1使用中、2损坏、3修理、4报废
     */
    @ApiModelProperty(value = "设备状态：0空闲、1使用中、2损坏、3修理、4报废")
    private Integer state;

    /**
     * 总量
     */
    @ApiModelProperty(value = "总量")
    private Integer total;

    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
    private String model;

    /**
     * 买入日期
     */
    @ApiModelProperty(value = "买入日期")
    private Date purchasedate;

    /**
     * 保质期
     */
    @ApiModelProperty(value = "保质期")
    private Date quality;

    /**
     * 生产厂家
     */
    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;
}