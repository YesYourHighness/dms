package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.DeviceInsertForm;
import cn.yesmylord.dms.form.DeviceUpdateForm;
import cn.yesmylord.dms.service.DeviceService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 董文浩
 * @Date 2021/2/4 12:43
 */
@RestController
@Api(tags = "设备管理接口")
@Slf4j
public class DeviceController {
    @Resource
    public DeviceService deviceService;

    @GetMapping("/device/list")
    @ApiOperation("设备列表信息")
    public ResponseVo deviceList(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        return deviceService.showDeviceList(pageNum, pageSize);
    }
    @GetMapping("/device/noScrapList")
    @ApiOperation("非损坏设备列表信息")
    public ResponseVo deviceNoScrapList() {
        return deviceService.showNoScrapDeviceList();
    }
    @GetMapping("/device/freeList")
    @ApiOperation("空闲设备列表信息")
    public ResponseVo deviceFreeList() {
        return deviceService.showFreeDeviceList();
    }
    @GetMapping("/device/search")
    @ApiOperation("设备按名称查找")
    public ResponseVo deviceSearchByName(@RequestParam String deviceName,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        return deviceService.searchDeviceByName(deviceName,pageNum, pageSize);
    }

    @PostMapping("/device/insert")
    @ApiOperation("插入新设备")
    public ResponseVo deviceInsert(@RequestBody DeviceInsertForm deviceInsertForm) {
        return deviceService.insertDevice(deviceInsertForm);
    }

    @PutMapping("/device/update")
    @ApiOperation("更新设备信息")
    public ResponseVo deviceUpdate(@RequestBody DeviceUpdateForm deviceUpdateForm) {
        return deviceService.updateDevice(deviceUpdateForm);
    }

    @DeleteMapping("/device/delete")
    @ApiOperation("删除设备信息")
    public ResponseVo deviceDelete(@RequestParam Integer deviceId) {
        return deviceService.updateDeviceState(deviceId);
    }

}
