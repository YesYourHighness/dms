package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.ApplicationInsertForm;
import cn.yesmylord.dms.form.ApplicationUpdateForm;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface ApplicationService{

    ResponseVo showApplicationList(Integer pageNum, Integer pageSize);

    ResponseVo searchApplication(String name, Integer pageNum, Integer pageSize);

    ResponseVo updateApplication(ApplicationUpdateForm applicationUpdateForm);

    ResponseVo insertApplication(ApplicationInsertForm applicationInsertForm);

    ResponseVo updateApplicationState(Integer id);
}
