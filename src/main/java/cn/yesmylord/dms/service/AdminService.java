package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.AdminChangeForm;
import cn.yesmylord.dms.form.AdminLoginForm;
import cn.yesmylord.dms.utils.ResponseVo;

import javax.servlet.http.HttpSession;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface AdminService {

    ResponseVo login(AdminLoginForm adminlogin , HttpSession session);

    ResponseVo changePassword(AdminChangeForm adminChangeForm);
}
