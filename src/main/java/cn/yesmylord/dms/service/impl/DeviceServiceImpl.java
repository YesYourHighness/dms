package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.Category;
import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.dto.DeviceDto;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.DeviceInsertForm;
import cn.yesmylord.dms.form.DeviceUpdateForm;
import cn.yesmylord.dms.mapper.CategoryMapper;
import cn.yesmylord.dms.mapper.DeviceMapper;
import cn.yesmylord.dms.mapper.UserMapper;
import cn.yesmylord.dms.service.DeviceService;
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
public class DeviceServiceImpl implements DeviceService{

    @Resource
    private DeviceMapper deviceMapper;

    @Resource
    private UserMapper userMapper;
    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public ResponseVo showDeviceList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<DeviceDto> deviceList  = deviceMapper.showDeviceList();
        List<Category> categories = categoryMapper.showCategoryList();
        List<User> users = userMapper.showUserList();
        for (DeviceDto deviceDto : deviceList) {
            // 如果有类别，就设置类别名称
            if(deviceDto.getCategoryid()!=null){
                for (Category category : categories) {
                    if(category.getCategoryid().equals(deviceDto.getCategoryid())){
                        deviceDto.setCategoryName(category.getCategoryname());
                        break;
                    }
                }
            }
            // 如果有使用人 就设置使用人名称
            if(deviceDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(deviceDto.getUserid())){
                        deviceDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo searchDeviceByName(String deviceName, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<DeviceDto> deviceList  = deviceMapper.searchByDeviceName(deviceName);
        List<Category> categories = categoryMapper.showCategoryList();
        List<User> users = userMapper.showUserList();
        for (DeviceDto deviceDto : deviceList) {
            // 如果有类别，就设置类别名称
            if(deviceDto.getCategoryid()!=null){
                for (Category category : categories) {
                    if(category.getCategoryid().equals(deviceDto.getCategoryid())){
                        deviceDto.setCategoryName(category.getCategoryname());
                        break;
                    }
                }
            }
            // 如果有使用人 就设置使用人名称
            if(deviceDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(deviceDto.getUserid())){
                        deviceDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo insertDevice(DeviceInsertForm deviceInsertForm) {
        int status = deviceMapper.insertDevice(deviceInsertForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo updateDevice(DeviceUpdateForm deviceUpdateForm) {
        int status = deviceMapper.updateDevice(deviceUpdateForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo updateDeviceState(Integer deviceId) {
        int status = deviceMapper.updateDeviceState(deviceId);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo showNoScrapDeviceList() {
        List<DeviceDto> deviceList  = deviceMapper.showNoScrapDeviceList();
        List<Category> categories = categoryMapper.showCategoryList();
        List<User> users = userMapper.showUserList();
        for (DeviceDto deviceDto : deviceList) {
            // 如果有类别，就设置类别名称
            if(deviceDto.getCategoryid()!=null){
                for (Category category : categories) {
                    if(category.getCategoryid().equals(deviceDto.getCategoryid())){
                        deviceDto.setCategoryName(category.getCategoryname());
                        break;
                    }
                }
            }
            // 如果有使用人 就设置使用人名称
            if(deviceDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(deviceDto.getUserid())){
                        deviceDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        return ResponseVo.success(deviceList);
    }

    @Override
    public ResponseVo showFreeDeviceList() {
        List<DeviceDto> deviceList  = deviceMapper.showFreeDeviceList();
        List<Category> categories = categoryMapper.showCategoryList();
        List<User> users = userMapper.showUserList();
        for (DeviceDto deviceDto : deviceList) {
            // 如果有类别，就设置类别名称
            if(deviceDto.getCategoryid()!=null){
                for (Category category : categories) {
                    if(category.getCategoryid().equals(deviceDto.getCategoryid())){
                        deviceDto.setCategoryName(category.getCategoryname());
                        break;
                    }
                }
            }
            // 如果有使用人 就设置使用人名称
            if(deviceDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(deviceDto.getUserid())){
                        deviceDto.setUsername(user.getName());
                        break;
                    }
                }
            }
        }
        return ResponseVo.success(deviceList);
    }
}
