package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.Device;
import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.dto.ApplicationDto;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.ApplicationInsertForm;
import cn.yesmylord.dms.form.ApplicationUpdateForm;
import cn.yesmylord.dms.form.DeviceInsertForm;
import cn.yesmylord.dms.mapper.ApplicationMapper;
import cn.yesmylord.dms.mapper.DeviceMapper;
import cn.yesmylord.dms.mapper.UserMapper;
import cn.yesmylord.dms.service.ApplicationService;
import cn.yesmylord.dms.utils.ResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Resource
    private ApplicationMapper applicationMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public ResponseVo showApplicationList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<ApplicationDto> applicationDtos  = applicationMapper.showApplicationList();
        List<User> users = userMapper.showUserList();
        for (ApplicationDto applicationDto : applicationDtos) {
            if(applicationDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(applicationDto.getUserid())){
                        applicationDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo searchApplication(String name, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<ApplicationDto> applicationDtos  = applicationMapper.searchApplication(name);
        List<User> users = userMapper.showUserList();
        for (ApplicationDto applicationDto : applicationDtos) {
            if(applicationDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(applicationDto.getUserid())){
                        applicationDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo updateApplication(ApplicationUpdateForm applicationUpdateForm) {
        int status = applicationMapper.updateApplication(applicationUpdateForm);
        // 通过了申请设备
        if(applicationUpdateForm.getState()==1){
            DeviceInsertForm device = new DeviceInsertForm();
            device.setDevicename(applicationUpdateForm.getApplyname());
            device.setPrice(applicationUpdateForm.getPrice());
            device.setTotal(applicationUpdateForm.getNum());
            device.setPurchasedate(new Date(System.currentTimeMillis()));
            device.setManufacturer(applicationUpdateForm.getManufacturer());
            device.setUserid(null);
            device.setCategoryid(null);
            device.setState(0);
            deviceMapper.insertDevice(device);
        }
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo insertApplication(ApplicationInsertForm applicationInsertForm) {
        int status = applicationMapper.insertApplication(applicationInsertForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo updateApplicationState(Integer id) {
        int status = applicationMapper.updateApplicationState(id);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }
}
