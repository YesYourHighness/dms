package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.form.AdminChangeForm;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface AdminMapper {

    String selectByUsername(String username);


    void updatePassword(AdminChangeForm adminChangeForm);
}