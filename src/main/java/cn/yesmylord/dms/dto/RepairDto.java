package cn.yesmylord.dms.dto;

import lombok.Data;
import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/21 21:01
 */
@Data
public class RepairDto {
    private Integer logid;

    private Integer deviceid;

    private String deviceName;

    private Integer userid;

    private String username;

    /**
     * 申请日期
     */
    private Date applydate;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 备注
     */
    private String remark;

    private Integer state;
}
