package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.dto.DeviceDto;
import cn.yesmylord.dms.dto.ScrapDto;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.ScrapInsertForm;
import cn.yesmylord.dms.form.ScrapUpdateForm;
import cn.yesmylord.dms.mapper.DeviceMapper;
import cn.yesmylord.dms.mapper.ScrapMapper;
import cn.yesmylord.dms.mapper.UserMapper;
import cn.yesmylord.dms.service.ScrapService;
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
public class ScrapServiceImpl implements ScrapService{

    @Resource
    private ScrapMapper scrapMapper;
    @Resource
    private DeviceMapper deviceMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVo showScrapList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<ScrapDto> scrapList  = scrapMapper.showScrapList();
        List<DeviceDto> deviceDtos = deviceMapper.showDeviceList();
        List<User> users = userMapper.showUserList();
        for (ScrapDto scrapDto : scrapList) {
            if(scrapDto.getDeviceid()!=null){
                for (DeviceDto deviceDto : deviceDtos) {
                    if(deviceDto.getDeviceid().equals(scrapDto.getDeviceid())){
                        scrapDto.setDeviceName(deviceDto.getDevicename());
                    }
                }
            }
            if(scrapDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(scrapDto.getUserid())){
                        scrapDto.setUsername(user.getName());
                    }
                }
            }
        }

        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo searchScrapById(Integer id, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<ScrapDto> scrapList  = scrapMapper.searchScrapById(id);
        List<DeviceDto> deviceDtos = deviceMapper.showDeviceList();
        List<User> users = userMapper.showUserList();
        for (ScrapDto scrapDto : scrapList) {
            if(scrapDto.getDeviceid()!=null){
                for (DeviceDto deviceDto : deviceDtos) {
                    if(deviceDto.getDeviceid().equals(scrapDto.getDeviceid())){
                        scrapDto.setDeviceName(deviceDto.getDevicename());
                    }
                }
            }
            if(scrapDto.getUserid()!=null){
                for (User user : users) {
                    if(user.getUserid().equals(scrapDto.getUserid())){
                        scrapDto.setUsername(user.getName());
                    }
                }
            }
        }

        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo insertScrap(ScrapInsertForm scrapInsertForm) {
        int status = scrapMapper.insertScrap(scrapInsertForm);
        deviceMapper.changeState(4,scrapInsertForm.getDeviceid());
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo updateScrap(ScrapUpdateForm scrapUpdateForm) {
        int status = scrapMapper.updateScrap(scrapUpdateForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo deleteScrap(Integer id) {
        int status = scrapMapper.updateScrapState(id);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }
}
