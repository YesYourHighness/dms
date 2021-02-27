package cn.yesmylord.dms.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/21 19:08
 */
@Data
public class ApplicationInsertForm {
    private Integer userid;

    /**
     * 申请设备名
     */
    private String applyname;

    /**
     * 申请购买数量
     */
    private Integer num;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 申请时间
     */
    private Date applydate;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 状态：0发出申请、1申请成功、2申请拒绝、3申请搁置
     */
    private Integer state;
}
