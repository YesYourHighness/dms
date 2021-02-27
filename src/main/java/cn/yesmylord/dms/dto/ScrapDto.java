package cn.yesmylord.dms.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/22 11:16
 */
@Data
public class ScrapDto {
    private Integer scrapid;

    private Integer deviceid;

    private String deviceName;

    private Date scrapdate;

    private Integer userid;
    private String username;
    private Integer state;
}
