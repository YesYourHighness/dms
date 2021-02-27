package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.AdminChangeForm;
import cn.yesmylord.dms.form.AdminLoginForm;
import cn.yesmylord.dms.service.AdminService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:35
 */
@RestController
@Api(tags = "管理员通用接口")
@Slf4j
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation("管理员登录")
    ResponseVo adminLogin(@Valid @RequestBody AdminLoginForm adminlogin, HttpSession session){
        return adminService.login(adminlogin, session);
    }

    @PostMapping("/changePassword")
    @ApiOperation("管理员修改密码")
    ResponseVo adminLogin(@Valid @RequestBody AdminChangeForm adminChangeForm){
        return adminService.changePassword(adminChangeForm);
    }

}
