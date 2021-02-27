package cn.yesmylord.dms.form;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

/**
 * @author 董文浩
 * @Date 2021/2/22 11:25
 */
@Data
public class ScrapUpdateForm {
    private Integer scrapid;

    private Integer deviceid;

    private Date scrapdate;

    private Integer userid;
}
