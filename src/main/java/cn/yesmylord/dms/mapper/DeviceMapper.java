package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.domain.Device;
import cn.yesmylord.dms.dto.DeviceDto;
import cn.yesmylord.dms.form.DeviceInsertForm;
import cn.yesmylord.dms.form.DeviceUpdateForm;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface DeviceMapper {

    List<DeviceDto> showDeviceList();

    List<DeviceDto> searchByDeviceName(String deviceName);

    int insertDevice(DeviceInsertForm deviceInsertForm);

    int updateDevice(DeviceUpdateForm deviceUpdateForm);

    int updateDeviceState(Integer deviceId);

    int changeState(int i,Integer deviceId);

    List<DeviceDto> showFreeDeviceList();

    List<DeviceDto> showNoScrapDeviceList();
}