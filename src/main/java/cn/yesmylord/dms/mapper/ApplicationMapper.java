package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.domain.Application;
import cn.yesmylord.dms.domain.Device;
import cn.yesmylord.dms.dto.ApplicationDto;
import cn.yesmylord.dms.form.ApplicationInsertForm;
import cn.yesmylord.dms.form.ApplicationUpdateForm;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface ApplicationMapper {

    List<ApplicationDto> showApplicationList();

    List<ApplicationDto> searchApplication(String name);

    int updateApplication(ApplicationUpdateForm applicationUpdateForm);

    int insertApplication(ApplicationInsertForm applicationInsertForm);

    int updateApplicationState(Integer id);
}