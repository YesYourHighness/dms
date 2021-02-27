package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.UserInfoForm;
import cn.yesmylord.dms.form.UserInfoInsertForm;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface UserService {

    ResponseVo showUserList(Integer pageNum, Integer pageSize);

    ResponseVo updateUserInfo(UserInfoForm userInfoForm);

    ResponseVo deleteUser(Integer userId);

    ResponseVo insertUser(UserInfoInsertForm userInfoInsertForm);

    ResponseVo searchUserByName(String name, Integer pageNum, Integer pageSize);
}
