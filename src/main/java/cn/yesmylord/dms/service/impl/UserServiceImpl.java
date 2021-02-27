package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.UserInfoForm;
import cn.yesmylord.dms.form.UserInfoInsertForm;
import cn.yesmylord.dms.utils.ResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.yesmylord.dms.mapper.UserMapper;
import cn.yesmylord.dms.service.UserService;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVo showUserList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList  = userMapper.showUserList();
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo updateUserInfo(UserInfoForm userInfoForm) {
        int status = userMapper.updateUser(userInfoForm);
        if(status==1){
            return ResponseVo.success();
        }else {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
    }

    @Override
    public ResponseVo deleteUser(Integer userId) {
        int status = userMapper.updateUserState(userId);
        if(status==1){
            return ResponseVo.success();
        }else {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
    }

    @Override
    public ResponseVo insertUser(UserInfoInsertForm userInfoInsertForm) {
        int status = userMapper.insertUser(userInfoInsertForm);
        if(status==1){
            return ResponseVo.success();
        }else {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
    }

    @Override
    public ResponseVo searchUserByName(String name, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList  = userMapper.searchUserByName(name);
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

}
