package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.DeviceInsertForm;
import cn.yesmylord.dms.form.DeviceUpdateForm;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface DeviceService{

    ResponseVo showDeviceList(Integer pageNum, Integer pageSize);

    ResponseVo searchDeviceByName(String deviceName, Integer pageNum, Integer pageSize);

    ResponseVo insertDevice(DeviceInsertForm deviceInsertForm);

    ResponseVo updateDevice(DeviceUpdateForm deviceUpdateForm);

    ResponseVo updateDeviceState(Integer deviceId);

    ResponseVo showNoScrapDeviceList();

    ResponseVo showFreeDeviceList();
}
