package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.domain.User;
import cn.yesmylord.dms.form.UserInfoForm;
import cn.yesmylord.dms.form.UserInfoInsertForm;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface UserMapper {

    List<User> showUserList();

    int updateUser(UserInfoForm userInfoForm);

    int updateUserState(Integer userId);

    int insertUser(UserInfoInsertForm userInfoInsertForm);

    List<User> searchUserByName(String name);
}