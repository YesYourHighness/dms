package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.dto.DeviceDto;
import cn.yesmylord.dms.dto.RepairDto;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.RepairInsertForm;
import cn.yesmylord.dms.form.RepairUpdateDto;
import cn.yesmylord.dms.mapper.DeviceMapper;
import cn.yesmylord.dms.mapper.RepairlogMapper;
import cn.yesmylord.dms.mapper.UserMapper;
import cn.yesmylord.dms.service.RepairlogService;
import cn.yesmylord.dms.utils.ResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@Service
public class RepairlogServiceImpl implements RepairlogService{

    @Resource
    private RepairlogMapper repairlogMapper;
    @Resource
    private DeviceMapper deviceMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVo showRepairLogList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<RepairDto> repairDtos  = repairlogMapper.showRepairLogList();
        List<DeviceDto> deviceDtos = deviceMapper.showDeviceList();
        List<User> users = userMapper.showUserList();
        for (RepairDto repairDto : repairDtos) {
            if(repairDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(repairDto.getUserid())){
                        repairDto.setUsername(user.getName());
                        break;
                    }
                }
            }
            if(repairDto.getDeviceid()!=null){
                for (DeviceDto deviceDto : deviceDtos) {
                    if(deviceDto.getDeviceid().equals(repairDto.getDeviceid())){
                        repairDto.setDeviceName(deviceDto.getDevicename());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo insertRepair(RepairInsertForm repairInsertForm) {
        int status = repairlogMapper.insertRepair(repairInsertForm);
        deviceMapper.changeState(3,repairInsertForm.getDeviceid());
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo updateRepair(RepairUpdateDto repairUpdateDto) {
        int status = repairlogMapper.updateRepair(repairUpdateDto);
        if(repairUpdateDto.getState()==1){
            deviceMapper.changeState(0,repairUpdateDto.getDeviceid());
        }
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }


    @Override
    public ResponseVo deleteRepair(Integer id) {
        int status = repairlogMapper.updateRepairState(id);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo SearchRepairById(Integer id ,Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<RepairDto> repairDtos  = repairlogMapper.searchById(id);
        List<DeviceDto> deviceDtos = deviceMapper.showDeviceList();
        List<User> users = userMapper.showUserList();
        for (RepairDto repairDto : repairDtos) {
            if(repairDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(repairDto.getUserid())){
                        repairDto.setUsername(user.getName());
                        break;
                    }
                }
            }
            if(repairDto.getDeviceid()!=null){
                for (DeviceDto deviceDto : deviceDtos) {
                    if(deviceDto.getDeviceid().equals(repairDto.getDeviceid())){
                        repairDto.setDeviceName(deviceDto.getDevicename());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }
}
