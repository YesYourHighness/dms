package cn.yesmylord.dms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/21 12:13
 */
@Data
public class DeviceDto {
    private Integer deviceid;

    private String devicename;

    private Integer categoryid;

    private String categoryName;


    // 使用人
    private Integer userid;

    private String username;

    private BigDecimal price;

    /**
     * 设备状态：0空闲、1使用中、2损坏、3修理、4报废
     */
    private Integer state;

    /**
     * 总量
     */
    private Integer total;

    /**
     * 型号
     */
    private String model;

    /**
     * 买入日期
     */
    private Date purchasedate;

    /**
     * 保质期
     */
    private Date quality;

    /**
     * 生产厂家
     */
    private String manufacturer;
}
