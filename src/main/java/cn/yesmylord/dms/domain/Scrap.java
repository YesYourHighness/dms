package cn.yesmylord.dms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@ApiModel(value = "cn-yesmylord-dms-domain-Scrap")
@Data
public class Scrap {
    @ApiModelProperty(value = "")
    private Integer scrapid;

    @ApiModelProperty(value = "")
    private Integer deviceid;

    @ApiModelProperty(value = "")
    private Date scrapdate;

    @ApiModelProperty(value = "")
    private Integer userid;
}