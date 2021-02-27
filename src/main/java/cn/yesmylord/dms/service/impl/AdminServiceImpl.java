package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.AdminChangeForm;
import cn.yesmylord.dms.form.AdminLoginForm;
import cn.yesmylord.dms.utils.Md5;
import cn.yesmylord.dms.utils.ResponseVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.yesmylord.dms.mapper.AdminMapper;
import cn.yesmylord.dms.service.AdminService;
/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    @Override
    public ResponseVo login(AdminLoginForm adminlogin, HttpSession session) {
        String verifyCode = (String) session.getAttribute("verifyCode");
        if(verifyCode==null){
            return ResponseVo.error(ResponseEnum.SESSION_ERROR);
        }
        if(!verifyCode.equalsIgnoreCase(adminlogin.getVerifyCode())){
            return ResponseVo.error(ResponseEnum.VERIFY_CODE_ERROR);
        }
        String username = adminlogin.getUsername();
        String password = adminlogin.getPassword();
        System.out.println(username + password);
        String truePassword = adminMapper.selectByUsername(username);
        if(truePassword == null || "".equals(truePassword)){
            return ResponseVo.error(ResponseEnum.USERNAME_ERROR);
        }
        if(!Md5.md5Password(password).equals(truePassword)){
            return ResponseVo.error(ResponseEnum.PASSWORD_ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo changePassword(AdminChangeForm adminChangeForm) {
        String username = adminChangeForm.getUsername();
        String password = adminChangeForm.getOldPassword();
        String truePassword = adminMapper.selectByUsername(username);
        if(truePassword == null || "".equals(truePassword)){
            return ResponseVo.error(ResponseEnum.USERNAME_ERROR);
        }
        if(!Md5.md5Password(password).equals(truePassword)){
            return ResponseVo.error(ResponseEnum.PASSWORD_ERROR);
        }
        adminChangeForm.setNewPassword(Md5.md5Password(adminChangeForm.getNewPassword()));
        adminMapper.updatePassword(adminChangeForm);
        return ResponseVo.success("修改密码成功");
    }
}
