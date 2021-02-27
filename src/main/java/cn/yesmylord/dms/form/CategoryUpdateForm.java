package cn.yesmylord.dms.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 董文浩
 * @Date 2021/2/21 11:40
 */
@Data
public class CategoryUpdateForm {
    private Integer categoryid;

    private String categoryname;

    private String remarks;

}
