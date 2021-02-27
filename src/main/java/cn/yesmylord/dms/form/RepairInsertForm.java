package cn.yesmylord.dms.form;

import lombok.Data;

import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/21 21:12
 */
@Data
public class RepairInsertForm {
    private Integer deviceid;

    private Integer userid;

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
